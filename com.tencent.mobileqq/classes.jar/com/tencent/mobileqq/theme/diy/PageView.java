package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class PageView
  extends RelativeLayout
{
  public static final int PIC_DEFAULT_BG = 0;
  public static final int PIC_DIY_BG = 1;
  public static final int PIC_THEME_SHOT = 2;
  static final String TAG = "ThemeDiyPageView";
  Drawable bgDrawable;
  ResData bgResData;
  ThemeDIYData mData;
  View mMaskColor;
  RelativeLayout mRLayout;
  View mShotView;
  View mUserBgView;
  boolean needBlur;
  int pageIndex;
  int pich;
  int picw;
  ResData shotResData;
  
  public PageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void init(ThemeDIYData paramThemeDIYData, int paramInt1, int paramInt2, int paramInt3, ThemeBackground paramThemeBackground)
  {
    this.pageIndex = paramInt1;
    this.mData = paramThemeDIYData;
    this.mRLayout = ((RelativeLayout)super.findViewById(2131375310));
    paramThemeDIYData = (RelativeLayout.LayoutParams)this.mRLayout.getLayoutParams();
    paramThemeDIYData.width = paramInt2;
    paramThemeDIYData.height = paramInt3;
    this.pich = paramInt3;
    this.picw = paramInt2;
    this.mUserBgView = super.findViewById(2131375311);
    this.mMaskColor = super.findViewById(2131375312);
    if (this.mData.orgMarkColor == 0) {
      if (this.mMaskColor.getParent() != null)
      {
        super.removeView(this.mMaskColor);
        this.mMaskColor = null;
      }
    }
    for (;;)
    {
      this.mShotView = super.findViewById(2131375313);
      return;
      this.mMaskColor.setBackgroundColor(super.getResources().getColor(this.mData.orgMarkColor));
    }
  }
  
  void setProgressBar(boolean paramBoolean)
  {
    Object localObject = this.mRLayout.findViewById(2131365698);
    if (localObject != null)
    {
      localObject = (ProgressBar)localObject;
      if (!paramBoolean) {
        break label151;
      }
      if (((this.bgResData != null) && (this.bgResData.state < 2)) || ((this.shotResData != null) && (this.shotResData.state < 2))) {
        break label65;
      }
    }
    label65:
    while ((localObject == null) || (((ProgressBar)localObject).getParent() == null) || (((this.bgResData == null) || (this.bgResData.state >= 2)) && ((this.shotResData == null) || (this.shotResData.state >= 2))))
    {
      do
      {
        return;
        localObject = null;
        break;
      } while (localObject != null);
      localObject = new ProgressBar(super.getContext());
      ((ProgressBar)localObject).setId(2131365698);
      ((ProgressBar)localObject).setIndeterminateDrawable(super.getResources().getDrawable(2130838602));
      int i = AIOUtils.a(16.0F, super.getResources());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.bottomMargin = i;
      localLayoutParams.leftMargin = i;
      localLayoutParams.addRule(13);
      this.mRLayout.addView((View)localObject, localLayoutParams);
      return;
    }
    label151:
    this.mRLayout.removeView((View)localObject);
  }
  
  boolean showPic(ResSuitData paramResSuitData, ResData paramResData, boolean paramBoolean, Drawable paramDrawable)
  {
    if (paramResSuitData == null) {
      return true;
    }
    Object localObject2;
    if ((paramResSuitData instanceof ResSuitData.BgSuit))
    {
      localObject2 = (ResSuitData.BgSuit)paramResSuitData;
      localObject1 = paramResData;
      if (paramResData == null) {
        localObject1 = DIYThemeUtils.getResData(null, (ResSuitData)localObject2, 110, ((ResSuitData.BgSuit)localObject2).previewImg);
      }
      if (this.mMaskColor != null) {
        this.mMaskColor.setVisibility(0);
      }
      if ("99".equals(paramResSuitData.id)) {
        if ((this.mData.tryOnBgBigOrgRD != null) && (!TextUtils.isEmpty(this.mData.tryOnBgBigOrgRD.path)))
        {
          ((ResData)localObject1).path = this.mData.tryOnBgBigOrgRD.path;
          paramResData = (ResData)localObject1;
          localObject1 = paramDrawable;
          if (paramDrawable == null) {
            localObject1 = DIYThemeUtils.getDIYDrawable(super.getContext(), paramResData, this.picw, this.pich, this.pageIndex, true);
          }
          this.mUserBgView.setBackgroundDrawable((Drawable)localObject1);
          this.needBlur = false;
          if (!"100".equals(paramResSuitData.id)) {
            break label431;
          }
          this.bgDrawable = ((Drawable)localObject1);
        }
      }
      for (;;)
      {
        paramDrawable = paramResData;
        localObject2 = localObject1;
        if (paramBoolean)
        {
          this.mData.tryOnBgBigOrgRD = paramResData;
          localObject2 = localObject1;
          paramDrawable = paramResData;
        }
        label202:
        if (!QLog.isColorLevel()) {
          break label521;
        }
        localObject1 = new StringBuilder().append("showPic type:");
        if (!(paramResSuitData instanceof ResSuitData.BgSuit)) {
          break label551;
        }
        paramResData = "bg";
        label232:
        paramResData = ((StringBuilder)localObject1).append(paramResData).append(", id:").append(paramResSuitData.id).append(", isTryOn:").append(paramBoolean).append(", drawable:").append(localObject2);
        if (paramDrawable == null) {
          break label558;
        }
        paramResSuitData = ", path:" + paramDrawable.path + ", url:" + paramDrawable.url;
        label312:
        QLog.d("ThemeDiyPageView", 2, paramResSuitData);
        return true;
        ((ResData)localObject1).resID = ((ResSuitData.BgSuit)localObject2).resID;
        QLog.e("ThemeDiyPageView", 1, "showPic type: bg , DIY_UPLOAD_BG_ID Error;");
        paramResData = (ResData)localObject1;
        break;
        if ("100".equals(paramResSuitData.id))
        {
          ((ResData)localObject1).resID = ((ResSuitData.BgSuit)localObject2).resID;
          if (this.mMaskColor == null) {
            break label425;
          }
          this.mMaskColor.setVisibility(8);
          paramResData = (ResData)localObject1;
          break;
        }
        localObject2 = ((ResSuitData.BgSuit)paramResSuitData).resData;
        if (localObject2 != null)
        {
          paramResData = (ResData)localObject2;
          if (!TextUtils.isEmpty(((ResData)localObject2).path)) {
            break;
          }
        }
        label425:
        paramResData = (ResData)localObject1;
        break;
        label431:
        if (!paramBoolean)
        {
          this.bgDrawable = ((Drawable)localObject1);
          this.needBlur = true;
        }
      }
    }
    Object localObject1 = (ResSuitData.StyleSuit)paramResSuitData;
    if (this.pageIndex == 0)
    {
      paramDrawable = ((ResSuitData.StyleSuit)localObject1).setFrontImg;
      label469:
      if (paramResData != null) {
        break label565;
      }
      paramResData = DIYThemeUtils.getResData(null, (ResSuitData)localObject1, 201, paramDrawable);
    }
    label521:
    label551:
    label558:
    label565:
    for (;;)
    {
      localObject2 = DIYThemeUtils.getDIYDrawable(super.getContext(), paramResData, this.picw, this.pich, this.pageIndex, true);
      this.mShotView.setBackgroundDrawable((Drawable)localObject2);
      paramDrawable = paramResData;
      break label202;
      break;
      if (1 == this.pageIndex)
      {
        paramDrawable = ((ResSuitData.StyleSuit)localObject1).msgFrontImg;
        break label469;
      }
      paramDrawable = ((ResSuitData.StyleSuit)localObject1).chatFrontImg;
      break label469;
      paramResData = "style";
      break label232;
      paramResSuitData = "resData=null";
      break label312;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.PageView
 * JD-Core Version:    0.7.0.1
 */