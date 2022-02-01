package com.tencent.mobileqq.widget.share;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ShareActionSheetV2$ActionSheetItemAdapter
  extends BaseAdapter
{
  private ShareActionSheetV2 a;
  private List<ShareActionSheetBuilder.ActionSheetItem> b;
  private LayoutInflater c;
  private int d = 0;
  private ShareActionSheetV2.ActionSheetItemAdapter.IconFactory e;
  private Resources f;
  
  public ShareActionSheetV2$ActionSheetItemAdapter(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ActionSheetItemAdapter() called with: context = [");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], objects = [");
      localStringBuilder.append(paramList);
      localStringBuilder.append("] #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      QLog.d("ShareActionSheetV2", 2, localStringBuilder.toString());
    }
    this.b = paramList;
    this.c = LayoutInflater.from(paramContext);
    this.a = paramShareActionSheetV2;
  }
  
  private static void a(int paramInt, String paramString, ImageView paramImageView, ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder, ActionSheetItemAdapter paramActionSheetItemAdapter, ShareActionSheetV2 paramShareActionSheetV2)
  {
    if (paramImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramInt != 0) {
        if (paramInt != 1)
        {
          if ((paramInt != 1000) && (paramInt != 1004)) {
            if (paramInt != 3000)
            {
              if (paramInt != 6000)
              {
                if ((paramInt == 10008) || (paramInt == 10010)) {
                  break label118;
                }
                paramInt = -1;
                break label120;
              }
            }
            else
            {
              paramInt = 101;
              break label120;
            }
          }
        }
        else
        {
          int i = 4;
          paramInt = i;
          if (TextUtils.isEmpty(paramActionSheetItemViewHolder.c.argus)) {
            break label120;
          }
          paramInt = i;
          if (!paramActionSheetItemViewHolder.c.argus.contains("isNewTroop=1")) {
            break label120;
          }
          paramInt = 113;
          break label120;
        }
      }
      label118:
      paramInt = 1;
      label120:
      if (paramInt == -1) {
        return;
      }
      if (ShareActionSheetV2.j(paramShareActionSheetV2) == null) {
        ShareActionSheetV2.a(paramShareActionSheetV2, new SparseArray());
      }
      INonMainProcAvatarLoader localINonMainProcAvatarLoader = (INonMainProcAvatarLoader)ShareActionSheetV2.j(paramShareActionSheetV2).get(paramInt);
      paramActionSheetItemAdapter = localINonMainProcAvatarLoader;
      if (localINonMainProcAvatarLoader == null)
      {
        paramActionSheetItemAdapter = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(paramShareActionSheetV2.a, paramInt);
        paramActionSheetItemAdapter.a((byte)3);
        paramActionSheetItemAdapter.a();
        ShareActionSheetV2.j(paramShareActionSheetV2).put(paramInt, paramActionSheetItemAdapter);
      }
      paramImageView.setTag(paramString);
      paramActionSheetItemAdapter.a(ShareActionSheetV2.k(paramShareActionSheetV2));
      paramString = paramActionSheetItemAdapter.a(paramString, true);
      if (paramString == null) {
        return;
      }
      paramActionSheetItemViewHolder.c.iconDrawable = new BitmapDrawable(paramString);
      b(paramActionSheetItemViewHolder);
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder)
  {
    if (paramActionSheetItemViewHolder.c.action == 72) {
      a(paramActionSheetItemViewHolder.c.uinType, paramActionSheetItemViewHolder.c.uin, paramActionSheetItemViewHolder.b, paramActionSheetItemViewHolder, this, this.a);
    }
  }
  
  private boolean a()
  {
    ShareActionSheetV2 localShareActionSheetV2 = this.a;
    return (localShareActionSheetV2 != null) && (ShareActionSheetV2.i(localShareActionSheetV2));
  }
  
  private static void b(ShareActionSheetBuilder.ActionSheetItemViewHolder paramActionSheetItemViewHolder)
  {
    if (paramActionSheetItemViewHolder.c.iconDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramActionSheetItemViewHolder.b.setBackground(paramActionSheetItemViewHolder.c.iconDrawable);
        return;
      }
      paramActionSheetItemViewHolder.b.setBackgroundDrawable(paramActionSheetItemViewHolder.c.iconDrawable);
      return;
    }
    paramActionSheetItemViewHolder.b.setBackgroundResource(paramActionSheetItemViewHolder.c.icon);
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt)
  {
    if (this.b != null)
    {
      if (paramInt < 0) {
        return null;
      }
      int j = -1;
      int i = 0;
      while (i < this.b.size())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.b.get(i);
        int k = j;
        if (localActionSheetItem != null)
        {
          k = j;
          if (localActionSheetItem.visibility == 0) {
            k = j + 1;
          }
        }
        if (k == paramInt) {
          return localActionSheetItem;
        }
        i += 1;
        j = k;
      }
    }
    return null;
  }
  
  public int getCount()
  {
    Object localObject = this.b;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next();
      if ((localActionSheetItem != null) && (localActionSheetItem.visibility == 0)) {
        i += 1;
      }
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.f == null) {
      this.f = paramViewGroup.getContext().getResources();
    }
    if (this.d == 0) {
      this.d = ((int)this.f.getDimension(2131297127));
    }
    if (this.e == null) {
      this.e = new ShareActionSheetV2.ActionSheetItemAdapter.IconFactory(paramViewGroup.getContext(), this);
    }
    int j = 0;
    Object localObject1;
    if (paramView == null)
    {
      paramView = this.c.inflate(2131624526, paramViewGroup, false);
      localObject1 = new ShareActionSheetBuilder.ActionSheetItemViewHolder();
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b = ((ImageView)paramView.findViewById(2131445759));
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a = ((TextView)paramView.findViewById(2131445760));
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (ShareActionSheetBuilder.ActionSheetItemViewHolder)paramView.getTag();
    }
    ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c = a(paramInt);
    if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(") == null !!!");
      QLog.e("ShareActionSheetV2", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      paramView.setId(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.id);
      float f1 = this.f.getDimension(2131297127);
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.getPaint().setTextSize(this.f.getDimensionPixelSize(2131299839));
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.setMaxWidth((int)f1);
      ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a.setText(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.label);
      int i = -8947849;
      Object localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).a;
      if (!((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.enable) {
        i = 2138535799;
      }
      ((TextView)localObject2).setTextColor(i);
      if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconNeedBg)
      {
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconDrawable != null) {
          localObject2 = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.iconDrawable;
        } else {
          localObject2 = this.f.getDrawable(((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.icon);
        }
        i = ((Drawable)localObject2).getIntrinsicWidth();
        int k = ((Drawable)localObject2).getIntrinsicHeight();
        int m = this.d;
        if (m > i) {
          i = (int)((m - i) / 2.0F);
        } else {
          i = 0;
        }
        m = this.d;
        if (m > k) {
          j = (int)((m - k) / 2.0F);
        }
        localObject2 = this.e.a((Drawable)localObject2, i, j);
        if (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.enable)
        {
          Drawable localDrawable = ShareActionSheetV2.ActionSheetItemAdapter.IconFactory.a(this.e, (Drawable)localObject2);
          localObject2 = this.e.a((Drawable)localObject2, localDrawable);
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setImageDrawable((Drawable)localObject2);
        }
        else
        {
          localObject2 = ShareActionSheetV2.ActionSheetItemAdapter.IconFactory.b(this.e, (Drawable)localObject2);
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setImageDrawable((Drawable)localObject2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setBackground(null);
        } else {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setBackgroundDrawable(null);
        }
      }
      else
      {
        if ((((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.action != 72) && (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).c.action != 73)) {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setImageResource(2130837657);
        } else if (QQTheme.isNowSimpleUI()) {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setImageResource(2130837659);
        } else {
          ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1).b.setImageResource(2130837658);
        }
        b((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1);
        a((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject1);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */