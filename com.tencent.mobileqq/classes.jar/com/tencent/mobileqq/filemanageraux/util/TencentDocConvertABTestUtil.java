package com.tencent.mobileqq.filemanageraux.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.DocClickTypeRunnable;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TencentDocConvertABTestUtil
{
  private static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return 106;
    }
    return a(paramAppInterface.getApp(), 53.0F);
  }
  
  public static List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem> a()
  {
    return (List)TencentDocEditConvertConfigProcessor.a().a().get("wording");
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, View paramView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ITencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (paramActivity == null) {
        return;
      }
      paramActivity = paramActivity.getResources();
      if (paramActivity == null) {
        return;
      }
      Object localObject = c(paramTeamWorkFileImportInfo.c);
      ArrayList localArrayList = new ArrayList();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        if (paramTeamWorkFileImportInfo.a != 1)
        {
          paramTeamWorkFileImportInfo = ((List)localObject).iterator();
          while (paramTeamWorkFileImportInfo.hasNext())
          {
            localObject = (TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)paramTeamWorkFileImportInfo.next();
            if (((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject).i() != 2) {
              localArrayList.add(localObject);
            }
          }
        }
        localArrayList.addAll((Collection)localObject);
      }
      a(paramAppInterface, paramActivity, paramView, localArrayList, paramDocClickTypeRunnable);
    }
  }
  
  private static void a(AppInterface paramAppInterface, Resources paramResources, View paramView, List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem> paramList, ITencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable)
  {
    if ((paramView != null) && (paramDocClickTypeRunnable != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      paramResources = (ViewGroup)paramView.findViewById(2131433423);
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131429650);
      if (paramResources != null)
      {
        if (localViewGroup == null) {
          return;
        }
        paramView.setVisibility(8);
        paramResources.setVisibility(8);
        localViewGroup.setVisibility(8);
        LayoutInflater localLayoutInflater = (LayoutInflater)BaseApplication.getContext().getSystemService("layout_inflater");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem localTencentDocEditConvertConfigItem = (TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)paramList.next();
          int i = localTencentDocEditConvertConfigItem.a();
          if (i != 1)
          {
            if (i != 2) {
              QLog.w("TencentDocConvertABTestUtil", 2, "can not show edit entrance");
            } else {
              a(paramAppInterface, paramView, paramDocClickTypeRunnable, paramResources, localViewGroup, localLayoutInflater, localTencentDocEditConvertConfigItem);
            }
          }
          else {
            a(paramAppInterface, paramView, paramDocClickTypeRunnable, paramResources, localLayoutInflater, localTencentDocEditConvertConfigItem);
          }
        }
      }
    }
  }
  
  private static void a(AppInterface paramAppInterface, View paramView, ITencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem paramTencentDocEditConvertConfigItem)
  {
    paramView.setVisibility(0);
    paramViewGroup.setVisibility(0);
    paramView = paramLayoutInflater.inflate(2131627085, paramViewGroup, false);
    paramLayoutInflater = (GradientDrawable)paramViewGroup.getBackground();
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setAlpha(Math.round(paramTencentDocEditConvertConfigItem.c() * 255.0F));
      if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.b())) {
        try
        {
          paramLayoutInflater.setColor(b(paramTencentDocEditConvertConfigItem.b()));
        }
        catch (NumberFormatException paramLayoutInflater)
        {
          QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", paramLayoutInflater);
        }
      }
    }
    if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.e())) {
      try
      {
        ((TextView)paramView.findViewById(2131448295)).setTextColor(b(paramTencentDocEditConvertConfigItem.e()));
      }
      catch (NumberFormatException paramLayoutInflater)
      {
        QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", paramLayoutInflater);
      }
    }
    if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.d())) {
      ((TextView)paramView.findViewById(2131448295)).setText(paramTencentDocEditConvertConfigItem.d());
    }
    if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.f()))
    {
      paramLayoutInflater = (URLImageView)paramView.findViewById(2131436285);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(paramTencentDocEditConvertConfigItem.f(), localURLDrawableOptions));
    }
    paramView.setOnClickListener(new TencentDocConvertABTestUtil.2(paramAppInterface, paramTencentDocEditConvertConfigItem.g(), paramDocClickTypeRunnable, paramTencentDocEditConvertConfigItem));
    if (paramTencentDocEditConvertConfigItem.i() == 2) {
      paramDocClickTypeRunnable.a((ImageView)paramView.findViewById(2131449075));
    }
    ReportController.b(paramAppInterface, "dc00898", "", "", paramTencentDocEditConvertConfigItem.h(), paramTencentDocEditConvertConfigItem.h(), 0, 0, "", "", "", "");
    paramViewGroup.addView(paramView);
  }
  
  private static void a(AppInterface paramAppInterface, View paramView, ITencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, LayoutInflater paramLayoutInflater, TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem paramTencentDocEditConvertConfigItem)
  {
    paramView.setVisibility(0);
    paramViewGroup2.setVisibility(0);
    paramView = paramLayoutInflater.inflate(2131627085, paramViewGroup1, false);
    paramViewGroup1 = (LayerDrawable)paramViewGroup2.getBackground();
    if (paramViewGroup1 != null)
    {
      paramViewGroup1 = (GradientDrawable)paramViewGroup1.findDrawableByLayerId(2131429234);
      paramViewGroup1.setAlpha(Math.round(paramTencentDocEditConvertConfigItem.c() * 255.0F));
      if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.b())) {
        try
        {
          paramViewGroup1.setColor(b(paramTencentDocEditConvertConfigItem.b()));
        }
        catch (NumberFormatException paramViewGroup1)
        {
          QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", paramViewGroup1);
        }
      }
    }
    if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.e())) {
      try
      {
        ((TextView)paramView.findViewById(2131448295)).setTextColor(b(paramTencentDocEditConvertConfigItem.e()));
      }
      catch (NumberFormatException paramViewGroup1)
      {
        QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", paramViewGroup1);
      }
    }
    if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.d())) {
      ((TextView)paramView.findViewById(2131448295)).setText(paramTencentDocEditConvertConfigItem.d());
    }
    if (!TextUtils.isEmpty(paramTencentDocEditConvertConfigItem.f()))
    {
      paramViewGroup1 = (URLImageView)paramView.findViewById(2131436285);
      paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup1.setImageDrawable(URLDrawable.getDrawable(paramTencentDocEditConvertConfigItem.f(), paramLayoutInflater));
    }
    paramView.setOnClickListener(new TencentDocConvertABTestUtil.1(paramAppInterface, paramTencentDocEditConvertConfigItem.g(), paramDocClickTypeRunnable, paramTencentDocEditConvertConfigItem));
    if (paramTencentDocEditConvertConfigItem.i() == 2) {
      paramDocClickTypeRunnable.a((ImageView)paramView.findViewById(2131449075));
    }
    ReportController.b(paramAppInterface, "dc00898", "", "", paramTencentDocEditConvertConfigItem.h(), paramTencentDocEditConvertConfigItem.h(), 0, 0, "", "", "", "");
    paramViewGroup2.addView(paramView);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && (a(paramTeamWorkFileImportInfo.c));
  }
  
  public static boolean a(String paramString)
  {
    paramString = c(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.size() > 0)
      {
        bool1 = bool2;
        if (((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)paramString.get(0)).a() != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static int b(String paramString)
  {
    return Integer.decode(paramString).intValue() | 0xFF000000;
  }
  
  private static List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem> c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = d(paramString).toLowerCase().replace(".", "");
    return (List)TencentDocEditConvertConfigProcessor.a().a().get(paramString);
  }
  
  private static String d(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    if (paramString.endsWith(".rename") == true)
    {
      String str = paramString.replace(".rename", "");
      i = str.lastIndexOf(".");
      if (i == -1) {
        return "";
      }
      if (str.substring(i).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk") == true) {
        return ".apk.rename";
      }
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.util.TencentDocConvertABTestUtil
 * JD-Core Version:    0.7.0.1
 */