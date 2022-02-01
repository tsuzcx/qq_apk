package com.tencent.mobileqq.filemanageraux.widget;

import android.content.Context;
import android.content.res.Resources;
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
import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import aoot;
import arqo;
import arqp;
import arqq;
import auve;
import bdll;
import beaj;
import beav;
import bedq;
import bhmq;
import bhnv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DocQBBottomView
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  auve jdField_a_of_type_Auve;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public DocQBBottomView(Context paramContext)
  {
    super(paramContext, null);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560923, this, true);
    b();
  }
  
  public DocQBBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560923, this, true);
    b();
  }
  
  public DocQBBottomView(Context paramContext, auve paramauve)
  {
    this(paramContext);
    this.jdField_a_of_type_Auve = paramauve;
  }
  
  private Drawable a()
  {
    Drawable localDrawable1 = getResources().getDrawable(2130844353);
    Drawable localDrawable2 = bhmq.a(localDrawable1, 2368548);
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
        return aoot.a((AppInterface)localObject, 1, paramString);
      }
      if (paramInt == 1) {
        return aoot.a((AppInterface)localObject, 4, paramString);
      }
      if (paramInt == 3000) {
        return aoot.a((AppInterface)localObject, 101, paramString);
      }
    }
    return null;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b())
    {
      arqp localarqp = arqq.a().a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b);
      if ((localarqp != null) && (!TextUtils.isEmpty(localarqp.jdField_a_of_type_JavaLangString))) {
        return localarqp.jdField_a_of_type_JavaLangString;
      }
      return anzj.a(2131702287);
    }
    return anzj.a(2131697482);
  }
  
  private void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (beav)((QQAppInterface)localObject).a(120);
      if ((localObject != null) && (paramTeamWorkFileImportInfo != null))
      {
        if (!((beav)localObject).a(paramTeamWorkFileImportInfo))
        {
          paramTeamWorkFileImportInfo.g = 0;
          ((beav)localObject).a(paramTeamWorkFileImportInfo);
        }
        bedq.a(null, "0X800ABA6");
        beaj.a(getContext(), paramTeamWorkFileImportInfo, null);
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int j = 1;
    Object localObject = arqq.a();
    int i;
    if (paramBoolean)
    {
      localObject = ((arqo)localObject).b;
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
      bdll.b(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
      return;
      localObject = ((arqo)localObject).d;
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
    setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373668));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131373667));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373669));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a());
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b()) && (arqq.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b)))
    {
      d();
      return;
    }
    Drawable localDrawable = a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
      return;
    }
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Auve != null) {
      this.jdField_a_of_type_Auve.a();
    }
    if (this.c)
    {
      StringBuilder localStringBuilder = new StringBuilder(a());
      localStringBuilder.append(anzj.a(2131718695));
      QQToast.a(getContext(), 1, localStringBuilder.toString(), 0).a();
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Auve != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(anzj.a(2131697480));
      localStringBuilder.append(a());
      this.jdField_a_of_type_Auve.a(localStringBuilder.toString());
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
          if (this.jdField_a_of_type_Auve != null) {
            this.jdField_a_of_type_Auve.a();
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
        e();
        return;
      case 4: 
        this.d = true;
        return;
      }
      onClick(this);
    } while (this.jdField_a_of_type_Auve == null);
    this.jdField_a_of_type_Auve.a();
    return;
    if (paramInt == 3) {
      e();
    }
    this.jdField_a_of_type_Int = paramInt;
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
      bedq.a(null, "0X800A637");
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString);
      localBundle.putBoolean("temp_preview_from_qq", true);
      localBundle.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
      TeamWorkDocEditBrowserActivity.a(getContext(), localBundle, false);
      return;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramObject == null) {}
    do
    {
      do
      {
        return;
        if (!(paramObject instanceof String)) {
          break;
        }
      } while (!paramObject.equals("open"));
      onClick(this);
      return;
    } while (!(paramObject instanceof Boolean));
    this.b = ((Boolean)paramObject).booleanValue();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    ((View)paramView.getParent()).performClick();
    bdll.b(null, "dc00898", "", "", "0X800AF72", "0X800AF72", 2, 0, "", "", "", "");
    if (!bhnv.d(BaseApplication.getContext())) {
      QQToast.a(getContext(), anzj.a(2131702278), 0).a();
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
          this.c = true;
          f();
        }
        else if (this.jdField_a_of_type_Int == 3)
        {
          this.c = true;
          f();
          beaj.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
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
              if (arqq.a().b(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b))
              {
                a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
                bool = true;
              }
              else
              {
                localObject = BaseApplicationImpl.sApplication.getRuntime();
                if ((localObject instanceof QQAppInterface))
                {
                  localObject = (beav)((QQAppInterface)localObject).a(120);
                  if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (!((beav)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo)))
                  {
                    bedq.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k + "-" + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d);
                    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 0;
                    ((beav)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
                  }
                }
                bool = true;
              }
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c()) {
            if (this.jdField_a_of_type_Boolean)
            {
              if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null))
              {
                if (this.b)
                {
                  if (this.jdField_a_of_type_JavaLangString.indexOf("?") > 0) {
                    this.jdField_a_of_type_JavaLangString += "&converFrom=qqFile";
                  }
                }
                else
                {
                  label428:
                  if (!this.b) {
                    break label522;
                  }
                  bedq.a(null, "0X800ABAB");
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
                  break label428;
                  label522:
                  bedq.a(null, "0X800ABAC");
                }
              }
            }
            else {
              a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
            }
          }
        }
      }
    }
  }
  
  public void setTeamWorkFileImportInfo(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView
 * JD-Core Version:    0.7.0.1
 */