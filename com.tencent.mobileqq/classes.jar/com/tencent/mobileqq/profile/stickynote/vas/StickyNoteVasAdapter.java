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
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.JceProtocol;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130847520);
  }
  
  private Drawable a(String paramString1, String paramString2)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      paramString1 = new URL("sig_cover", paramString2, paramString1);
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
      return localObject;
    }
    catch (MalformedURLException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickyNoteVasAdapter", 2, paramString1.getMessage());
        }
        paramString1 = null;
      }
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str3 = HardCodeUtil.a(2131704699);
    String str2 = HardCodeUtil.a(2131719890);
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString2))
    {
      str1 = str2;
      if (paramString2.contains("svip")) {
        str1 = HardCodeUtil.a(2131719889);
      }
    }
    DialogUtil.a(paramContext, 230, str3, paramString3, HardCodeUtil.a(2131704700), str1, new StickyNoteVasAdapter.3(this, paramContext, paramString1, paramString2, paramString4), new StickyNoteVasAdapter.4(this)).show();
  }
  
  public static boolean a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
    case 1: 
      return true;
    case 4: 
      return VipUtils.c(localQQAppInterface);
    case 5: 
      return VipUtils.b(localQQAppInterface);
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130847824;
    case 0: 
    case 1: 
      return 2130847823;
    case 4: 
      return 2130847828;
    case 5: 
      return 2130847827;
    case 21: 
      return 2130847826;
    }
    return 2130847825;
  }
  
  public Drawable a(Context paramContext, Drawable paramDrawable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramDrawable;
    }
    return new LayerDrawable(new Drawable[] { paramDrawable, paramContext.getResources().getDrawable(2130850732) });
  }
  
  public Drawable a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 14606046;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (!paramString.contains("#")) {
        str = "#" + paramString;
      }
      i = Color.parseColor(str);
    }
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i + 1291845632, i + -2147483648 });
    if (!paramBoolean) {
      return paramString;
    }
    return new LayerDrawable(new Drawable[] { paramString, paramContext.getResources().getDrawable(2130850732) });
  }
  
  public StickyNoteVasAdapter.BgHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new StickyNoteVasAdapter.BgHolder(this, View.inflate(paramViewGroup.getContext(), 2131561546, null));
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
    if ((this.jdField_a_of_type_QCUniBusiSimpleItemDetail != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter$AuthListener);
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
    new JceProtocol("QC.UniBusinessUserInfoServer.UniBusinessUserInfoObj", "QcUniBusinessUserInfo.UniBusiGetOneItemWithCheck", "stReq", "stRsp").a("UniBusiGetOneItemWithCheck", new UniBusiGetOneItemWithCheckReq(JceProtocol.a(), paramInt1, paramInt2), new UniBusiGetOneItemWithCheckRsp(), new StickyNoteVasAdapter.5(this, paramAuthListener), false);
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
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramBgHolder, paramInt, getItemId(paramInt));
      return;
    }
    UniBusiSimpleItemDetail localUniBusiSimpleItemDetail = (UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramBgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localUniBusiSimpleItemDetail.name);
    boolean bool;
    label72:
    int i;
    if (this.b == localUniBusiSimpleItemDetail.itemId)
    {
      bool = true;
      if (this.c != localUniBusiSimpleItemDetail.itemId) {
        break label308;
      }
      i = 1;
      label86:
      paramBgHolder.b.setVisibility(8);
      if (i != 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.jdField_a_of_type_Int;
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
        if (i == 2) {
          paramBgHolder.b.setVisibility(0);
        }
      }
      QLog.d("StickyNoteVasAdapter", 1, " mAppId:" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int != 9) {
        break label313;
      }
      paramBgHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setBackgroundDrawable(a(paramBgHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.getContext(), localUniBusiSimpleItemDetail.itemBgColor, bool));
      i = (ScreenUtil.getRealWidth(paramBgHolder.itemView.getContext()) - ScreenUtil.dip2px(96.0F)) / 3;
      Object localObject = paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = ((int)(i * 0.57F));
      paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramBgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(String.valueOf(localUniBusiSimpleItemDetail.itemId), localUniBusiSimpleItemDetail.image));
    }
    for (;;)
    {
      a(paramBgHolder.jdField_a_of_type_AndroidWidgetTextView, localUniBusiSimpleItemDetail.feeType);
      paramBgHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setOnClickListener(new StickyNoteVasAdapter.1(this, localUniBusiSimpleItemDetail));
      break;
      bool = false;
      break label72;
      label308:
      i = 0;
      break label86;
      label313:
      paramBgHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setBackgroundDrawable(a(paramBgHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.getContext(), a(String.valueOf(localUniBusiSimpleItemDetail.itemId), localUniBusiSimpleItemDetail.image), bool));
    }
  }
  
  public void a(ArrayList<UniBusiSimpleItemDetail> paramArrayList, boolean paramBoolean)
  {
    int i;
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      notifyDataSetChanged();
      if (this.d != 0) {
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(i)).itemId == this.d) {
          this.jdField_a_of_type_QCUniBusiSimpleItemDetail = ((UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      else
      {
        if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail != null)
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_Int, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, -1, this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteVasAdapter$AuthListener);
        }
        this.d = 0;
        return;
        this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
        break;
      }
      i += 1;
    }
  }
  
  public void b()
  {
    notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$StickyNoteShopSetting != null)
    {
      if (this.jdField_a_of_type_Int != 5) {
        break label60;
      }
      i = 0;
      if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stFontItem != null) {
        i = this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stFontItem.fontType;
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$StickyNoteShopSetting.b(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, i);
    }
    label60:
    while (this.jdField_a_of_type_Int != 9) {
      return;
    }
    int j = 16777215;
    int i = j;
    if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem != null)
    {
      i = j;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem.fontColor)) {
        i = Color.parseColor(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem.fontColor);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout$StickyNoteShopSetting.a(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, i);
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
    this.c = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.a(false);
    }
  }
  
  public void c(int paramInt)
  {
    this.b = -1;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
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
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      int j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.jdField_a_of_type_Int == 2)
      {
        StickyNoteShopLayout localStickyNoteShopLayout = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
        j = Math.min(i, 30);
      }
      return j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter
 * JD-Core Version:    0.7.0.1
 */