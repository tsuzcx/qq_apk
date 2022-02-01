package com.tencent.mobileqq.wink.pick.circle.part;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.wink.pick.album.data.WinkAlbumLogicData;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListFragment;
import com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;
import com.tencent.mobileqq.wink.pick.circle.part.base.WinkCircleBasePart;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WinkCircleTitleChipPart
  extends WinkCircleBasePart
  implements View.OnClickListener
{
  private View a;
  private TextView b;
  private long c;
  private boolean f;
  
  public WinkCircleTitleChipPart(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic)
  {
    super(paramWinkCirclePhotoListLogic);
    this.d.a(this);
  }
  
  public String a()
  {
    return "WinkCircleTitleChipPart";
  }
  
  public void a(View paramView)
  {
    this.a = paramView.findViewById(2131436180);
    this.b = ((TextView)paramView.findViewById(2131436211));
    this.a.setVisibility(0);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    if (this.f) {
      this.b.setVisibility(0);
    } else {
      this.b.setVisibility(8);
    }
    if ((j() instanceof WinkCirclePhotoListFragment))
    {
      paramView = (WinkCirclePhotoListFragment)j();
      String str = (String)WinkDatongCurrentParams.params.get("xsj_camera_clck_ref_pgid");
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put("xsj_camera_clck_ref_pgid", str);
      }
      paramView.a(this.a, "em_xsj_close_button", localHashMap);
    }
    d();
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  protected void d()
  {
    if (this.d.e().selectedPhotoList.size() + this.d.g().initialHasPickedNum < 1)
    {
      this.b.setEnabled(false);
      return;
    }
    this.b.setEnabled(true);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkCircleSelectChangeEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.c >= 1000L)
    {
      this.c = System.currentTimeMillis();
      if (this.d != null)
      {
        int i = paramView.getId();
        if (i == 2131436180) {
          this.d.a(paramView);
        } else if (i == 2131436211) {
          this.d.l();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof WinkCircleSelectChangeEvent)) {
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCircleTitleChipPart
 * JD-Core Version:    0.7.0.1
 */