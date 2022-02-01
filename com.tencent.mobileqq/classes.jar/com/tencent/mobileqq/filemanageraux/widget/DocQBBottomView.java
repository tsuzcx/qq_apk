package com.tencent.mobileqq.filemanageraux.widget;

import afur;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import anni;
import aoch;
import arax;
import aray;
import arbb;
import audj;
import bcst;
import bdho;
import bdia;
import bdkv;
import bgey;
import bgmo;
import bgnt;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class DocQBBottomView
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  audj jdField_a_of_type_Audj;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private boolean jdField_b_of_type_Boolean;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public DocQBBottomView(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560892, this, true);
    b();
  }
  
  public DocQBBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560892, this, true);
    b();
  }
  
  public DocQBBottomView(Context paramContext, audj paramaudj)
  {
    this(paramContext);
    this.jdField_a_of_type_Audj = paramaudj;
  }
  
  private Drawable a()
  {
    Drawable localDrawable1 = getResources().getDrawable(2130844339);
    Drawable localDrawable2 = bgmo.a(localDrawable1, 2368548);
    localDrawable2.setAlpha(127);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { -16842919 }, localDrawable1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable2);
    return localStateListDrawable;
  }
  
  private Drawable a(int paramInt, String paramString)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (paramInt == 0) {
        return aoch.a((AppInterface)localObject, 1, paramString);
      }
      if (paramInt == 1) {
        return aoch.a((AppInterface)localObject, 4, paramString);
      }
      if (paramInt == 3000) {
        return aoch.a((AppInterface)localObject, 101, paramString);
      }
    }
    return null;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b()) {
      return anni.a(2131702180);
    }
    return anni.a(2131697402);
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int j = 1;
    Object localObject = arbb.a();
    int i;
    if (paramBoolean)
    {
      localObject = ((arax)localObject).b;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = j;
        if (paramInt != 1)
        {
          if (paramInt != 3000) {
            break label80;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
      return;
      localObject = ((arax)localObject).d;
      break;
      label80:
      if (paramInt == 0) {
        i = 0;
      } else {
        i = 3;
      }
    }
  }
  
  private void b()
  {
    int i = afur.a(1.0F, getResources());
    int j = afur.a(31.0F, getResources());
    View localView = new View(getContext());
    localView.setBackgroundColor(Color.parseColor("#F3F3F3"));
    localView.setLayoutParams(new FrameLayout.LayoutParams(i, j, 16));
    addView(localView);
    setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373548);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373547));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373550));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131373546);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131373543));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131373544));
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131373545));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373549));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Audj != null) {
      this.jdField_a_of_type_Audj.a();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder(a());
      localStringBuilder.append(anni.a(2131718559));
      QQToast.a(getContext(), 1, localStringBuilder.toString(), 0).a();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Audj != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(anni.a(2131697400));
      localStringBuilder.append(a());
      this.jdField_a_of_type_Audj.a(localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if ((localViewGroup != null) && ((localViewGroup instanceof ViewGroup))) {
      localViewGroup.removeView(this);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 4) {
      if (paramInt == 3)
      {
        this.jdField_a_of_type_Int = 5;
        if (this.d)
        {
          this.d = false;
          onClick(this);
          if (this.jdField_a_of_type_Audj != null) {
            this.jdField_a_of_type_Audj.a();
          }
        }
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_Int = paramInt;
      switch (paramInt)
      {
      default: 
        return;
      case 3: 
        c();
        return;
      case 4: 
        this.d = true;
        return;
      }
      onClick(this);
    } while (this.jdField_a_of_type_Audj == null);
    this.jdField_a_of_type_Audj.a();
    return;
    if (paramInt == 3) {
      c();
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (paramObject == null) {
      if (paramInt > 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
      }
    }
    do
    {
      for (;;)
      {
        return;
        paramString = a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        if (paramString != null)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
          this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        return;
        if (!(paramObject instanceof List)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramString = (List)paramObject;
        if (paramString != null)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramObject = new URLImageView[3];
          paramObject[0] = this.jdField_a_of_type_ComTencentImageURLImageView;
          paramObject[1] = this.jdField_b_of_type_ComTencentImageURLImageView;
          paramObject[2] = this.jdField_c_of_type_ComTencentImageURLImageView;
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
          this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(8);
          paramInt = 0;
          while (paramInt < paramString.size())
          {
            Object localObject = ((aray)paramString.get(paramInt)).b;
            if (paramInt < 3)
            {
              localObject = URLDrawable.getDrawable((String)localObject, URLDrawable.URLDrawableOptions.obtain());
              int i = afur.a(18.0F, getResources());
              ((URLDrawable)localObject).setTag(bgey.b(i, i, i / 2));
              ((URLDrawable)localObject).setDecodeHandler(bgey.c);
              paramObject[paramInt].setVisibility(0);
              paramObject[paramInt].setImageDrawable((Drawable)localObject);
            }
            paramInt += 1;
          }
        }
      }
    } while (!(paramObject instanceof Boolean));
    this.jdField_b_of_type_Boolean = ((Boolean)paramObject).booleanValue();
    if (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramTeamWorkFileImportInfo != null)) {
      if (paramString.indexOf("?") <= 0) {
        break label91;
      }
    }
    label91:
    for (paramString = paramString + "&adtag=s_qq_file_inviteedit";; paramString = paramString + "?adtag=s_qq_file_inviteedit")
    {
      bdkv.a(null, "0X800A637");
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString);
      localBundle.putBoolean("temp_preview_from_qq", true);
      localBundle.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
      TeamWorkDocEditBrowserActivity.a(getContext(), localBundle, false);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    ((View)paramView.getParent()).performClick();
    bcst.b(null, "dc00898", "", "", "0X800AF72", "0X800AF72", 2, 0, "", "", "", "");
    if (!bgnt.d(BaseApplication.getContext())) {
      QQToast.a(getContext(), anni.a(2131702171), 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) {
        if (this.jdField_a_of_type_Int == 4)
        {
          this.d = true;
        }
        else if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2))
        {
          this.jdField_a_of_type_Int = 2;
          this.jdField_c_of_type_Boolean = true;
          d();
        }
        else if (this.jdField_a_of_type_Int == 3)
        {
          this.jdField_c_of_type_Boolean = true;
          d();
          bdho.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
        }
        else if (this.jdField_a_of_type_Int == 5)
        {
          Object localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b())
          {
            if (this.jdField_a_of_type_Boolean) {
              a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
            }
            for (;;)
            {
              a(bool, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int);
              break;
              localObject = BaseApplicationImpl.sApplication.getRuntime();
              if ((localObject instanceof QQAppInterface))
              {
                localObject = (bdia)((QQAppInterface)localObject).a(120);
                if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (!((bdia)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo)))
                {
                  bdkv.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k + "-" + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d);
                  this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 0;
                  ((bdia)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
                }
              }
              bool = true;
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c()) {
            if (this.jdField_a_of_type_Boolean)
            {
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null))
              {
                if (this.jdField_b_of_type_Boolean)
                {
                  if (this.jdField_a_of_type_JavaLangString.indexOf("?") > 0) {
                    this.jdField_a_of_type_JavaLangString += "&converFrom=qqFile";
                  }
                }
                else
                {
                  label399:
                  if (!this.jdField_b_of_type_Boolean) {
                    break label493;
                  }
                  bdkv.a(null, "0X800ABAB");
                }
                for (;;)
                {
                  localObject = new Bundle();
                  ((Bundle)localObject).putString("url", this.jdField_a_of_type_JavaLangString);
                  ((Bundle)localObject).putBoolean("temp_preview_from_qq", true);
                  ((Bundle)localObject).putParcelable("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
                  TeamWorkDocEditBrowserActivity.a(getContext(), (Bundle)localObject, false);
                  break;
                  this.jdField_a_of_type_JavaLangString += "?converFrom=qqFile";
                  break label399;
                  label493:
                  bdkv.a(null, "0X800ABAC");
                }
              }
            }
            else
            {
              localObject = BaseApplicationImpl.sApplication.getRuntime();
              if ((localObject instanceof QQAppInterface))
              {
                localObject = (bdia)((QQAppInterface)localObject).a(120);
                if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null))
                {
                  if (!((bdia)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 0;
                    ((bdia)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
                  }
                  bdkv.a(null, "0X800ABA6");
                  bdho.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, null);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setTeamWorkFileImportInfo(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView
 * JD-Core Version:    0.7.0.1
 */