package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;

public abstract class BaseTroopAioMsgNavigateBarDelegate
  implements INavigateBar
{
  protected int a;
  protected Context a;
  protected BaseSessionInfo a;
  protected QQAppInterface a;
  protected final String a;
  
  public BaseTroopAioMsgNavigateBarDelegate(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Navigate.");
    localStringBuilder.append(getClass().getSimpleName());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @DrawableRes
  public int a(int paramInt)
  {
    return 0;
  }
  
  public BaseTroopAioMsgNavigateBarDelegate a(int paramInt)
  {
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString) {}
  
  public void a(int paramInt1, TroopAioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong) {}
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public boolean a(int paramInt, URLThemeImageView paramURLThemeImageView, String paramString)
  {
    return false;
  }
  
  protected boolean a(@NonNull MessageRecord paramMessageRecord, long paramLong1, long paramLong2)
  {
    if ((paramMessageRecord.shmsgseq <= paramLong2) && (QLog.isColorLevel()))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShMsgSeqCanShow, shMsgSeq = ");
      localStringBuilder.append(paramMessageRecord.shmsgseq);
      localStringBuilder.append(", firstMsgSeq = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", lastReadSeq = ");
      localStringBuilder.append(paramLong2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return (paramMessageRecord.shmsgseq < paramLong1) && (paramMessageRecord.shmsgseq > paramLong2);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseTroopAioMsgNavigateBarDelegate
 * JD-Core Version:    0.7.0.1
 */