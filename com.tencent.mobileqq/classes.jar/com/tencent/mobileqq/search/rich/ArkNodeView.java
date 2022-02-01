package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkNodeView
  extends RichNodeViewBase
  implements ArkAppView.ArkAppViewEvent
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView;
  private WeakReference<IArkNodeViewEvent> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  public ArkNodeView(IRichNode paramIRichNode, Context paramContext)
  {
    super(paramIRichNode, paramContext);
  }
  
  public View a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131561418, null, false);
    this.jdField_a_of_type_AndroidViewView = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView = ((ArkAppView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362961));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    ((ArkAppRootLayout)paramContext).setDisableParentReturn(false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.b = false;
    a(1);
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (IArkNodeViewEvent)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((IArkNodeViewEvent)localObject).a(paramInt);
  }
  
  public void a(ArkNodeContainer paramArkNodeContainer)
  {
    ArkAppView localArkAppView = this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView;
    if (localArkAppView != null)
    {
      if (paramArkNodeContainer == null) {
        return;
      }
      localArkAppView.a(paramArkNodeContainer, this);
    }
  }
  
  public void a(IArkNodeViewEvent paramIArkNodeViewEvent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIArkNodeViewEvent);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    this.b = true;
    a(1);
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkNodeView", 2, "onLoadFailed, show no result");
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      a(false);
      return;
    }
    ((LinearLayout)localObject).setVisibility(0);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ArkNodeView.1(this));
    } else {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    }
    localObject = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376349);
    if (localObject != null) {
      if (paramString == null) {
        ((TextView)localObject).setText(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getString(2131690168));
      } else {
        ((TextView)localObject).setText(paramString);
      }
    }
    paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376342);
    if (paramString != null)
    {
      if (paramBoolean) {
        paramInt = 2130838629;
      } else {
        paramInt = 2130838628;
      }
      paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (this.b)
      {
        bool = paramBoolean;
        if (this.jdField_a_of_type_Boolean) {
          bool = false;
        }
      }
    }
    super.a(bool);
  }
  
  public View b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView;
  }
  
  public void b()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(0);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    ArkAppView localArkAppView = this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView;
    if (localArkAppView != null)
    {
      localArkAppView.a();
      this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView = null;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    super.d();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkNodeView
 * JD-Core Version:    0.7.0.1
 */