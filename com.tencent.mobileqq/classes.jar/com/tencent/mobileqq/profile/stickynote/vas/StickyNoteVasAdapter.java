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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
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
  private int jdField_a_of_type_Int;
  private UniBusiSimpleItemDetail jdField_a_of_type_QCUniBusiSimpleItemDetail;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new StickyNoteVasAdapter.6(this);
  private StickyNoteShopLayout.StickyNoteShopSetting jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$StickyNoteShopSetting;
  private StickyNoteShopLayout jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  public StickyNoteVasAdapter.AuthListener a;
  private ArrayList<UniBusiSimpleItemDetail> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  private int b = -1;
  private int c = -1;
  private int d = 0;
  private final int e = 0;
  private final int f = 1;
  
  public StickyNoteVasAdapter(Context paramContext, ArrayList<UniBusiSimpleItemDetail> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter$AuthListener = new StickyNoteVasAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130847388);
  }
  
  private Drawable a(String paramString1, String paramString2)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramString2.mFailedDrawable = ((Drawable)localObject);
        paramString2.mLoadingDrawable = ((Drawable)localObject);
        paramString2.mPlayGifImage = true;
        localObject = URLDrawable.getDrawable(paramString1, paramString2);
        ((URLDrawable)localObject).addHeader("my_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        ((URLDrawable)localObject).setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
      }
    }
    return localObject;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str2 = HardCodeUtil.a(2131704775);
    String str1 = HardCodeUtil.a(2131719622);
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.contains("svip"))) {
      str1 = HardCodeUtil.a(2131719621);
    }
    DialogUtil.a(paramContext, 230, str2, paramString3, HardCodeUtil.a(2131704776), str1, new StickyNoteVasAdapter.3(this, paramContext, paramString1, paramString2, paramString4), new StickyNoteVasAdapter.4(this)).show();
  }
  
  public static boolean a(int paramInt)
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
        return VasUtil.a(localQQAppInterface).getVipStatus().isSVip();
      }
      return VasUtil.a(localQQAppInterface).getVipStatus().isVip();
    }
    return true;
  }
  
  public int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public int a(int paramInt)
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
              return 2130847691;
            }
            return 2130847692;
          }
          return 2130847693;
        }
        return 2130847694;
      }
      return 2130847695;
    }
    return 2130847690;
  }
  
  public Drawable a(Context paramContext, Drawable paramDrawable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramDrawable;
    }
    return new LayerDrawable(new Drawable[] { paramDrawable, paramContext.getResources().getDrawable(2130850658) });
  }
  
  public Drawable a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i;
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
      i = Color.parseColor((String)localObject);
    }
    else
    {
      i = 14606046;
    }
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i + 1291845632, i + -2147483648 });
    if (!paramBoolean) {
      return paramString;
    }
    return new LayerDrawable(new Drawable[] { paramString, paramContext.getResources().getDrawable(2130850658) });
  }
  
  public StickyNoteVasAdapter.BgHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new StickyNoteVasAdapter.BgHolder(this, View.inflate(paramViewGroup.getContext(), 2131561387, null));
    if (paramInt == 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return paramViewGroup;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    return paramViewGroup;
  }
  
  public void a()
  {
    UniBusiSimpleItemDetail localUniBusiSimpleItemDetail = this.jdField_a_of_type_QCUniBusiSimpleItemDetail;
    if ((localUniBusiSimpleItemDetail != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_Int, localUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter$AuthListener);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, StickyNoteVasAdapter.AuthListener paramAuthListener)
  {
    if ((a(paramInt3)) && (paramAuthListener != null))
    {
      paramAuthListener.a(true, null);
      return;
    }
    ((IJce)QRoute.api(IJce.class)).build("QC.UniBusinessUserInfoServer.UniBusinessUserInfoObj", "QcUniBusinessUserInfo.UniBusiGetOneItemWithCheck", "stReq", "stRsp").request("UniBusiGetOneItemWithCheck", new UniBusiGetOneItemWithCheckReq(IJce.Util.a(), paramInt1, paramInt2), new UniBusiGetOneItemWithCheckRsp(), new StickyNoteVasAdapter.5(this, paramAuthListener), false);
  }
  
  public void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setCompoundDrawablePadding(ViewUtils.b(4.0F));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a(paramInt), 0);
  }
  
  public void a(StickyNoteShopLayout.StickyNoteShopSetting paramStickyNoteShopSetting)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$StickyNoteShopSetting = paramStickyNoteShopSetting;
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = paramStickyNoteShopLayout;
  }
  
  public void a(StickyNoteVasAdapter.BgHolder paramBgHolder, int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (((ArrayList)localObject1).get(paramInt) != null))
    {
      localObject1 = (UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramBgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((UniBusiSimpleItemDetail)localObject1).name);
      boolean bool;
      if (this.b == ((UniBusiSimpleItemDetail)localObject1).itemId) {
        bool = true;
      } else {
        bool = false;
      }
      int i;
      if (this.c == ((UniBusiSimpleItemDetail)localObject1).itemId) {
        i = 1;
      } else {
        i = 0;
      }
      paramBgHolder.b.setVisibility(8);
      if (i != 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.jdField_a_of_type_Int;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
        if (i == 2) {
          paramBgHolder.b.setVisibility(0);
        }
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" mAppId:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      QLog.d("StickyNoteVasAdapter", 1, ((StringBuilder)localObject2).toString());
      if (this.jdField_a_of_type_Int == 9)
      {
        paramBgHolder.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.setBackgroundDrawable(a(paramBgHolder.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.getContext(), ((UniBusiSimpleItemDetail)localObject1).itemBgColor, bool));
        i = (ScreenUtil.getRealWidth(paramBgHolder.itemView.getContext()) - ScreenUtil.dip2px(96.0F)) / 3;
        localObject2 = paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = i;
        ((ViewGroup.LayoutParams)localObject2).height = ((int)(i * 0.57F));
        paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(String.valueOf(((UniBusiSimpleItemDetail)localObject1).itemId), ((UniBusiSimpleItemDetail)localObject1).image));
      }
      else
      {
        paramBgHolder.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.setBackgroundDrawable(a(paramBgHolder.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.getContext(), a(String.valueOf(((UniBusiSimpleItemDetail)localObject1).itemId), ((UniBusiSimpleItemDetail)localObject1).image), bool));
      }
      a(paramBgHolder.jdField_a_of_type_AndroidWidgetTextView, ((UniBusiSimpleItemDetail)localObject1).feeType);
      paramBgHolder.jdField_a_of_type_ComTencentWidgetRoundRelativeLayout.setOnClickListener(new StickyNoteVasAdapter.1(this, (UniBusiSimpleItemDetail)localObject1));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBgHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(ArrayList<UniBusiSimpleItemDetail> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if (localArrayList != null)
      {
        localArrayList.addAll(paramArrayList);
        break label30;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    label30:
    notifyDataSetChanged();
    if (this.d != 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (((UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(i)).itemId == this.d)
          {
            this.jdField_a_of_type_QCUniBusiSimpleItemDetail = ((UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(i));
            break;
          }
          i += 1;
        }
      }
      paramArrayList = this.jdField_a_of_type_QCUniBusiSimpleItemDetail;
      if (paramArrayList != null)
      {
        this.jdField_a_of_type_Boolean = true;
        a(this.jdField_a_of_type_Int, paramArrayList.itemId, -1, this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter$AuthListener);
      }
      this.d = 0;
    }
  }
  
  public void b()
  {
    notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$StickyNoteShopSetting != null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 5)
      {
        i = 0;
        if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stFontItem != null) {
          i = this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stFontItem.fontType;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$StickyNoteShopSetting.b(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, i);
        return;
      }
      if (i == 9)
      {
        int j = 16777215;
        i = j;
        if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem != null)
        {
          i = j;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem.fontColor)) {
            i = Color.parseColor(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem.fontColor);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$StickyNoteShopSetting.a(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, i);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
    this.c = paramInt;
    StickyNoteShopLayout localStickyNoteShopLayout = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != null) {
      localStickyNoteShopLayout.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    this.b = -1;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(i)).itemId == paramInt)
      {
        this.b = paramInt;
        this.jdField_a_of_type_QCUniBusiSimpleItemDetail = ((UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        notifyDataSetChanged();
        return;
      }
      i += 1;
    }
  }
  
  public int getItemCount()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ArrayList)localObject).size();
    }
    int j = i;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.jdField_a_of_type_Int == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
      j = Math.min(i, 30);
    }
    return j;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter
 * JD-Core Version:    0.7.0.1
 */