package com.tencent.mobileqq.location.ui.headset;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.location.ui.HeadSetView;
import com.tencent.mobileqq.location.ui.LocationAvatarHelper;
import com.tencent.mobileqq.location.ui.LocationShareController;
import com.tencent.mobileqq.location.ui.MapUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class HeadAdapter
  extends BaseAdapter
  implements DecodeTaskCompletionListener
{
  private final HorizontalListView a;
  private final HeadSetView b;
  private LocationShareController c;
  private final Context d;
  private List<String> e;
  
  public HeadAdapter(Context paramContext, HorizontalListView paramHorizontalListView, HeadSetView paramHeadSetView)
  {
    this.d = paramContext;
    this.a = paramHorizontalListView;
    this.b = paramHeadSetView;
    this.e = new ArrayList();
  }
  
  protected static <T extends View> T a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  private void b(@NonNull List<String> paramList)
  {
    this.e = paramList;
  }
  
  public void a(LocationShareController paramLocationShareController)
  {
    this.c = paramLocationShareController;
    this.c.a(this);
  }
  
  public void a(@NonNull List<String> paramList)
  {
    if ((this.e.equals(paramList)) && (QLog.isColorLevel())) {
      QLog.d("HeadAdapter", 2, new Object[] { "notifyDataSetChangedAdvance: invoked. same list, ", " newHeadSetList: ", paramList, " headSetList: ", this.e });
    }
    b(paramList);
    if (this.e.size() <= this.b.b()) {
      this.a.setOverScrollMode(1);
    } else {
      this.a.setOverScrollMode(0);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.e.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)getItem(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.d).inflate(2131625215, null);
      localObject1 = new HeadAdapter.VH(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("HeadAdapter", 2, new Object[] { "getView: invoked. ", " position: ", Integer.valueOf(paramInt) });
      }
      ((HeadAdapter.VH)localObject1).b = str;
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (HeadAdapter.VH)paramView.getTag();
      ((HeadAdapter.VH)localObject1).b = str;
    }
    paramView.setOnClickListener(new HeadAdapter.1(this, str));
    Bitmap localBitmap = LocationAvatarHelper.a().a(((HeadAdapter.VH)localObject1).b);
    Object localObject2 = localBitmap;
    if (localBitmap == null) {
      localObject2 = BaseImageUtil.k();
    }
    ((HeadAdapter.VH)localObject1).a.setImageBitmap((Bitmap)localObject2);
    Object localObject1 = ((IFriendNameService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFriendNameService.class, "")).getFriendNick(str);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("正在共享位置");
    MapUtils.a(paramView, ((StringBuilder)localObject2).toString());
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.a.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.a.getChildAt(paramInt1).getTag();
      if ((localObject instanceof HeadAdapter.VH))
      {
        localObject = (HeadAdapter.VH)localObject;
        if ((paramString != null) && (paramString.equals(((HeadAdapter.VH)localObject).b)))
        {
          if (paramBitmap == null) {
            break;
          }
          paramString = LocationAvatarHelper.a().a(paramString);
          if (paramString == null) {
            break;
          }
          ((HeadAdapter.VH)localObject).a.setImageBitmap(paramString);
          return;
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.headset.HeadAdapter
 * JD-Core Version:    0.7.0.1
 */