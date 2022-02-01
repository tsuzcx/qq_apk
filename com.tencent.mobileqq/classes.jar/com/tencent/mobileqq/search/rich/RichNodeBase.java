package com.tencent.mobileqq.search.rich;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class RichNodeBase
  implements IRichNode
{
  private int jdField_a_of_type_Int;
  protected Context a;
  protected QQAppInterface a;
  private IRichNodeView jdField_a_of_type_ComTencentMobileqqSearchRichIRichNodeView;
  private RichMetaData jdField_a_of_type_ComTencentMobileqqSearchRichRichMetaData = new RichMetaData();
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<IRichNodeEvent> jdField_a_of_type_JavaLangRefWeakReference;
  
  public IRichNodeView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichIRichNodeView;
  }
  
  protected abstract IRichNodeView a(Context paramContext);
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchRichRichMetaData.a();
  }
  
  protected void a() {}
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("create, serverdata:");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append("  extredata:");
      paramQQAppInterface.append(paramString2);
      paramQQAppInterface.append(" config:");
      paramQQAppInterface.append(paramString3);
      paramQQAppInterface.append(" templateid:");
      paramQQAppInterface.append(paramInt);
      QLog.d("RichNodeBase", 2, paramQQAppInterface.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichMetaData.a(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichMetaData.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichMetaData.b(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichIRichNodeView = a(paramContext);
  }
  
  public void a(IRichNodeEvent paramIRichNodeEvent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIRichNodeEvent);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateData, serverdata:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("  extredata:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" config:");
      localStringBuilder.append(paramString3);
      QLog.d("RichNodeBase", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichMetaData.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichMetaData.b(paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "pause");
    }
  }
  
  protected void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fireEvent, key:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" value:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("RichNodeBase", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (IRichNodeEvent)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IRichNodeEvent)localObject).a(this, paramString1, paramString2);
      }
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "resume");
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "destroy");
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    IRichNodeView localIRichNodeView = this.jdField_a_of_type_ComTencentMobileqqSearchRichIRichNodeView;
    if (localIRichNodeView != null)
    {
      localIRichNodeView.f();
      this.jdField_a_of_type_ComTencentMobileqqSearchRichIRichNodeView = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichMetaData = null;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "fireOnRichViewChangedEvent");
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (IRichNodeEvent)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IRichNodeEvent)localObject).a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeBase
 * JD-Core Version:    0.7.0.1
 */