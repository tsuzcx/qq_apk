package com.tencent.mobileqq.wink.pick.circle.part;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.pick.album.data.WinkAlbumLogicData;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import com.tencent.mobileqq.wink.pick.circle.adapter.PicPreviewMoveAdapter;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleChangeBottomTabVisibleEvent;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleTitleAlbumMenuChangeEvent;
import com.tencent.mobileqq.wink.pick.circle.helper.PicDragHelperCallback;
import com.tencent.mobileqq.wink.pick.circle.helper.PicItemDecoration;
import com.tencent.mobileqq.wink.pick.circle.part.base.WinkCircleBasePart;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.ArrayList;

public class WinkCircleSelectPanelPart
  extends WinkCircleBasePart
  implements SimpleEventReceiver
{
  public static int a = 3000;
  public static int b = 500;
  private ItemTouchHelper c;
  private PicDragHelperCallback f;
  private RecyclerView g;
  private TextView h;
  private View i;
  private TextView j;
  private ImageView k;
  private PicPreviewMoveAdapter l;
  private boolean m = true;
  
  public WinkCircleSelectPanelPart(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    super(paramWinkCirclePhotoListLogic);
    this.d.a(this);
  }
  
  private void b(View paramView)
  {
    this.i = paramView.findViewById(2131440199);
    this.g = ((RecyclerView)paramView.findViewById(2131445214));
    this.h = ((TextView)paramView.findViewById(2131448643));
    this.j = ((TextView)paramView.findViewById(2131448644));
    this.k = ((ImageView)paramView.findViewById(2131448285));
    this.i.setVisibility(8);
    this.l = new PicPreviewMoveAdapter(paramView.getContext(), this.d);
    this.l.a(this.d.d.selectedPhotoList);
    paramView = new LinearLayoutManager(paramView.getContext());
    paramView.setOrientation(0);
    this.g.setLayoutManager(paramView);
    this.g.addItemDecoration(new PicItemDecoration(8));
    this.g.setAdapter(this.l);
    this.l.a(new WinkCircleSelectPanelPart.2(this));
    this.f = new PicDragHelperCallback(this.l, null);
    this.f.a(1.2F);
    this.f.b(0.9F);
    this.f.a(new WinkCircleSelectPanelPart.3(this));
    this.c = new ItemTouchHelper(this.f);
    this.c.attachToRecyclerView(this.g);
    this.j.setVisibility(0);
    d();
    this.j.setOnClickListener(new WinkCircleSelectPanelPart.4(this));
    if (((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
      this.k.setVisibility(0);
    } else {
      this.k.setVisibility(8);
    }
    this.k.setOnClickListener(new WinkCircleSelectPanelPart.5(this));
    if ((this.d != null) && (this.d.b == 2)) {
      e();
    }
  }
  
  private void f()
  {
    if ((this.d != null) && (this.d.d != null) && (this.d.d.selectedPhotoList != null))
    {
      if (this.d.d.selectedPhotoList.size() > 0)
      {
        SimpleEventBus.getInstance().dispatchEvent(new WinkCircleChangeBottomTabVisibleEvent(Boolean.valueOf(false)));
        return;
      }
      SimpleEventBus.getInstance().dispatchEvent(new WinkCircleChangeBottomTabVisibleEvent(Boolean.valueOf(true)));
    }
  }
  
  public String a()
  {
    return "WinkCircleSelectPanelPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
  }
  
  protected void d()
  {
    int n = this.d.e().selectedPhotoList.size() + this.d.g().initialHasPickedNum;
    if (n < 1)
    {
      this.j.setEnabled(false);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("下一步(");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    this.j.setText((CharSequence)localObject);
    this.j.setEnabled(true);
  }
  
  public void e()
  {
    this.m = false;
    ImageView localImageView = this.k;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkCircleSelectChangeEvent.class);
    localArrayList.add(WinkCircleTitleAlbumMenuChangeEvent.class);
    return localArrayList;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    boolean bool = paramSimpleBaseEvent instanceof WinkCircleSelectChangeEvent;
    Boolean localBoolean = Boolean.valueOf(false);
    if (bool)
    {
      if ((this.d != null) && (this.d.n.isSinglePickMode))
      {
        this.i.setVisibility(8);
        this.d.l();
        return;
      }
      if ((this.d != null) && (this.d.d != null) && (this.d.d.selectedPhotoList != null))
      {
        QLog.d("WinkCircleSelectPanelPart", 4, "onReceiveEvent");
        if (this.d.d.selectedPhotoList.size() > 0)
        {
          this.i.setVisibility(0);
          this.l.notifyDataSetChanged();
          if (this.d.d.selectedPhotoList.size() >= 2)
          {
            SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("share", 4);
            bool = localSharedPreferences.getBoolean("ae_camera_is_show_tip", true);
            View localView = c().findViewById(2131437580);
            if (bool)
            {
              localView.setVisibility(0);
              localSharedPreferences.edit().putBoolean("ae_camera_is_show_tip", false).apply();
              localView.postDelayed(new WinkCircleSelectPanelPart.1(this, localView), a);
            }
            else
            {
              localView.setVisibility(8);
            }
          }
          if (!((WinkCircleSelectChangeEvent)paramSimpleBaseEvent).getImageDragEventFlag()) {
            this.g.smoothScrollToPosition(this.d.d.selectedPhotoList.size() - 1);
          }
          SimpleEventBus.getInstance().dispatchEvent(new WinkCircleChangeBottomTabVisibleEvent(localBoolean));
        }
        else
        {
          this.i.setVisibility(8);
          SimpleEventBus.getInstance().dispatchEvent(new WinkCircleChangeBottomTabVisibleEvent(Boolean.valueOf(true)));
        }
        d();
      }
    }
    else if ((paramSimpleBaseEvent instanceof WinkCircleTitleAlbumMenuChangeEvent))
    {
      paramSimpleBaseEvent = (WinkCircleTitleAlbumMenuChangeEvent)paramSimpleBaseEvent;
      if ((this.d != null) && (this.d.n.isSinglePickMode))
      {
        this.i.setVisibility(8);
        return;
      }
      if (paramSimpleBaseEvent.getIsShow())
      {
        this.i.setVisibility(8);
      }
      else if ((this.d != null) && (this.d.d != null) && (this.d.d.selectedPhotoList != null))
      {
        QLog.d("WinkCircleSelectPanelPart", 4, "onReceiveEvent");
        if (this.d.d.selectedPhotoList.size() > 0) {
          this.i.setVisibility(0);
        }
      }
      if (paramSimpleBaseEvent.getIsShow())
      {
        SimpleEventBus.getInstance().dispatchEvent(new WinkCircleChangeBottomTabVisibleEvent(localBoolean));
        return;
      }
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCircleSelectPanelPart
 * JD-Core Version:    0.7.0.1
 */