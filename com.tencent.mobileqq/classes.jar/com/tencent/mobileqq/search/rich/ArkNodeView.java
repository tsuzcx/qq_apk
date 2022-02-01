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
    paramContext = LayoutInflater.from(paramContext).inflate(2131561577, null, false);
    this.jdField_a_of_type_AndroidViewView = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView = ((ArkAppView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363013));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    ((ArkAppRootLayout)paramContext).setDisableParentReturn(false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.b = false;
    a(1);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    IArkNodeViewEvent localIArkNodeViewEvent;
    do
    {
      return;
      localIArkNodeViewEvent = (IArkNodeViewEvent)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localIArkNodeViewEvent == null);
    localIArkNodeViewEvent.a(paramInt);
  }
  
  public void a(ArkNodeContainer paramArkNodeContainer)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView == null) || (paramArkNodeContainer == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView.a(paramArkNodeContainer, this);
  }
  
  public void a(IArkNodeViewEvent paramIArkNodeViewEvent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIArkNodeViewEvent);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    this.b = true;
    a(1);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    TextView localTextView;
    label124:
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeView", 2, "onLoadFailed, show no result");
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        a(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ArkNodeView.1(this));
      localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376858);
      if (localTextView != null)
      {
        if (paramString != null) {
          break label169;
        }
        localTextView.setText(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext().getResources().getString(2131690251));
      }
      paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131376851);
    } while (paramString == null);
    if (paramBoolean) {}
    for (paramInt = 2130838791;; paramInt = 2130838783)
    {
      paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      break;
      label169:
      localTextView.setText(paramString);
      break label124;
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
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView.a();
      this.jdField_a_of_type_ComTencentMobileqqSearchRichArkAppView = null;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    super.d();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkNodeView
 * JD-Core Version:    0.7.0.1
 */