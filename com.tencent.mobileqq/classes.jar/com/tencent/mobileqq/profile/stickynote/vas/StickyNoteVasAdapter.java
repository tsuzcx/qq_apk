package com.tencent.mobileqq.profile.stickynote.vas;

import QC.UniBusiGetOneItemWithCheckReq;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleFontItem;
import QC.UniBusiSimpleItemDetail;
import QC.UniBusiSimpleSigItem;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRelativeLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class StickyNoteVasAdapter
  extends RecyclerView.Adapter<StickyNoteVasAdapter.BgHolder>
{
  public StickyNoteVasAdapter.AuthListener a = new StickyNoteVasAdapter.2(this);
  private ArrayList<UniBusiSimpleItemDetail> b;
  private StickyNoteShopLayout.StickyNoteShopSetting c;
  private int d;
  private Drawable e;
  private int f = -1;
  private int g = -1;
  private Context h;
  private UniBusiSimpleItemDetail i;
  private boolean j = false;
  private StickyNoteShopLayout k;
  private int l = 0;
  private final int m = 0;
  private final int n = 1;
  private URLDrawable.URLDrawableListener o = new StickyNoteVasAdapter.6(this);
  
  public StickyNoteVasAdapter(Context paramContext, ArrayList<UniBusiSimpleItemDetail> paramArrayList)
  {
    this.h = paramContext;
    this.b = paramArrayList;
    this.e = paramContext.getResources().getDrawable(2130849039);
  }
  
  private Drawable a(String paramString1, String paramString2)
  {
    Drawable localDrawable = this.e;
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = null;
      try
      {
        paramString1 = new URL("sig_cover", paramString2, paramString1);
      }
      catch (MalformedURLException paramString2)
      {
        paramString1 = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("StickyNoteVasAdapter", 2, paramString2.getMessage());
          paramString1 = (String)localObject;
        }
      }
      localObject = localDrawable;
      if (paramString1 != null)
      {
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        localObject = this.e;
        paramString2.mFailedDrawable = ((Drawable)localObject);
        paramString2.mLoadingDrawable = ((Drawable)localObject);
        paramString2.mPlayGifImage = true;
        localObject = URLDrawable.getDrawable(paramString1, paramString2);
        ((URLDrawable)localObject).addHeader("my_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        ((URLDrawable)localObject).setURLDrawableListener(this.o);
      }
    }
    return localObject;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str2 = HardCodeUtil.a(2131902677);
    String str1 = HardCodeUtil.a(2131917218);
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains("svip"))) {
      str1 = HardCodeUtil.a(2131917217);
    }
    DialogUtil.a(paramContext, 230, str2, paramString3, HardCodeUtil.a(2131898212), str1, new StickyNoteVasAdapter.3(this, paramContext, paramString1, paramString2, paramString4), new StickyNoteVasAdapter.4(this)).show();
  }
  
  public static boolean e(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if ((paramInt != 6) && (paramInt != 21) && (paramInt != 22)) {}
          return false;
        }
        return VasUtil.b(localQQAppInterface).getVipStatus().isSVip();
      }
      return VasUtil.b(localQQAppInterface).getVipStatus().isVip();
    }
    return true;
  }
  
  public Drawable a(Context paramContext, Drawable paramDrawable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramDrawable;
    }
    return new LayerDrawable(new Drawable[] { paramDrawable, paramContext.getResources().getDrawable(2130852462) });
  }
  
  public Drawable a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i1;
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramString;
      if (!paramString.contains("#"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      i1 = Color.parseColor((String)localObject);
    }
    else
    {
      i1 = 14606046;
    }
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i1 + 1291845632, i1 + -2147483648 });
    if (!paramBoolean) {
      return paramString;
    }
    return new LayerDrawable(new Drawable[] { paramString, paramContext.getResources().getDrawable(2130852462) });
  }
  
  public StickyNoteVasAdapter.BgHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new StickyNoteVasAdapter.BgHolder(this, View.inflate(paramViewGroup.getContext(), 2131627743, null));
    if (paramInt == 1)
    {
      paramViewGroup.d.setVisibility(0);
      return paramViewGroup;
    }
    paramViewGroup.d.setVisibility(8);
    return paramViewGroup;
  }
  
  public void a()
  {
    UniBusiSimpleItemDetail localUniBusiSimpleItemDetail = this.i;
    if ((localUniBusiSimpleItemDetail != null) && (this.j))
    {
      this.j = false;
      a(this.d, localUniBusiSimpleItemDetail.itemId, this.i.feeType, this.a);
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, StickyNoteVasAdapter.AuthListener paramAuthListener)
  {
    if ((e(paramInt3)) && (paramAuthListener != null))
    {
      paramAuthListener.a(true, null);
      return;
    }
    VasUtil.a().getJceRequset().build("QC.UniBusinessUserInfoServer.UniBusinessUserInfoObj", "QcUniBusinessUserInfo.UniBusiGetOneItemWithCheck", "stReq", "stRsp").request("UniBusiGetOneItemWithCheck", new UniBusiGetOneItemWithCheckReq(IJce.Util.a(), paramInt1, paramInt2), new UniBusiGetOneItemWithCheckRsp(), new StickyNoteVasAdapter.5(this, paramAuthListener), false);
  }
  
  public void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, c(paramInt), 0);
  }
  
  public void a(StickyNoteShopLayout.StickyNoteShopSetting paramStickyNoteShopSetting)
  {
    this.c = paramStickyNoteShopSetting;
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    this.k = paramStickyNoteShopLayout;
  }
  
  public void a(StickyNoteVasAdapter.BgHolder paramBgHolder, int paramInt)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((ArrayList)localObject1).get(paramInt) != null))
    {
      localObject1 = (UniBusiSimpleItemDetail)this.b.get(paramInt);
      paramBgHolder.a.setText(((UniBusiSimpleItemDetail)localObject1).name);
      boolean bool;
      if (this.f == ((UniBusiSimpleItemDetail)localObject1).itemId) {
        bool = true;
      } else {
        bool = false;
      }
      int i1;
      if (this.g == ((UniBusiSimpleItemDetail)localObject1).itemId) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      paramBgHolder.e.setVisibility(8);
      if (i1 != 0)
      {
        i1 = this.k.b;
        localObject2 = this.k;
        if (i1 == 2) {
          paramBgHolder.e.setVisibility(0);
        }
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" mAppId:");
      ((StringBuilder)localObject2).append(this.d);
      QLog.d("StickyNoteVasAdapter", 1, ((StringBuilder)localObject2).toString());
      if (this.d == 9)
      {
        paramBgHolder.c.setBackgroundDrawable(a(paramBgHolder.c.getContext(), ((UniBusiSimpleItemDetail)localObject1).itemBgColor, bool));
        i1 = (ScreenUtil.getRealWidth(paramBgHolder.itemView.getContext()) - ScreenUtil.dip2px(96.0F)) / 3;
        localObject2 = paramBgHolder.b.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = i1;
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(i1 * 0.57F));
        paramBgHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramBgHolder.b.setImageDrawable(a(String.valueOf(((UniBusiSimpleItemDetail)localObject1).itemId), ((UniBusiSimpleItemDetail)localObject1).image));
      }
      else
      {
        paramBgHolder.c.setBackgroundDrawable(a(paramBgHolder.c.getContext(), a(String.valueOf(((UniBusiSimpleItemDetail)localObject1).itemId), ((UniBusiSimpleItemDetail)localObject1).image), bool));
      }
      a(paramBgHolder.a, ((UniBusiSimpleItemDetail)localObject1).feeType);
      paramBgHolder.c.setOnClickListener(new StickyNoteVasAdapter.1(this, (UniBusiSimpleItemDetail)localObject1));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBgHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(ArrayList<UniBusiSimpleItemDetail> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArrayList localArrayList = this.b;
      if (localArrayList != null)
      {
        localArrayList.addAll(paramArrayList);
        break label30;
      }
    }
    this.b = paramArrayList;
    label30:
    notifyDataSetChanged();
    if (this.l != 0)
    {
      if (this.b != null)
      {
        int i1 = 0;
        while (i1 < this.b.size())
        {
          if (((UniBusiSimpleItemDetail)this.b.get(i1)).itemId == this.l)
          {
            this.i = ((UniBusiSimpleItemDetail)this.b.get(i1));
            break;
          }
          i1 += 1;
        }
      }
      paramArrayList = this.i;
      if (paramArrayList != null)
      {
        this.j = true;
        a(this.d, paramArrayList.itemId, -1, this.a);
      }
      this.l = 0;
    }
  }
  
  public void b()
  {
    notifyDataSetChanged();
    if (this.c != null)
    {
      int i1 = this.d;
      if (i1 == 5)
      {
        i1 = 0;
        if (this.i.stFontItem != null) {
          i1 = this.i.stFontItem.fontType;
        }
        this.c.b(this.i.itemId, i1);
        return;
      }
      if (i1 == 9)
      {
        int i2 = 16777215;
        i1 = i2;
        if (this.i.stSigItem != null)
        {
          i1 = i2;
          if (!TextUtils.isEmpty(this.i.stSigItem.fontColor)) {
            i1 = Color.parseColor(this.i.stSigItem.fontColor);
          }
        }
        this.c.a(this.i.itemId, i1);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.l = paramInt;
    this.g = paramInt;
    StickyNoteShopLayout localStickyNoteShopLayout = this.k;
    if (localStickyNoteShopLayout != null) {
      localStickyNoteShopLayout.a(false);
    }
  }
  
  public int c()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int c(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 21)
          {
            if (paramInt != 22) {
              return 2130849351;
            }
            return 2130849352;
          }
          return 2130849353;
        }
        return 2130849354;
      }
      return 2130849355;
    }
    return 2130849350;
  }
  
  public void d(int paramInt)
  {
    this.f = -1;
    if (this.b == null) {
      return;
    }
    int i1 = 0;
    while (i1 < this.b.size())
    {
      if (((UniBusiSimpleItemDetail)this.b.get(i1)).itemId == paramInt)
      {
        this.f = paramInt;
        this.i = ((UniBusiSimpleItemDetail)this.b.get(i1));
        notifyDataSetChanged();
        return;
      }
      i1 += 1;
    }
  }
  
  public int getItemCount()
  {
    Object localObject = this.b;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = ((ArrayList)localObject).size();
    }
    int i2 = i1;
    if (this.k.b == 2)
    {
      localObject = this.k;
      i2 = Math.min(i1, 30);
    }
    return i2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter
 * JD-Core Version:    0.7.0.1
 */