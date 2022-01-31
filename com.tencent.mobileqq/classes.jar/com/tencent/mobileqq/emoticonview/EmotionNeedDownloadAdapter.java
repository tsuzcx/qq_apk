package com.tencent.mobileqq.emoticonview;

import acns;
import acnt;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListener;
import com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager;

public abstract class EmotionNeedDownloadAdapter
  extends BaseEmotionAdapter
{
  EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new acnt(this);
  EmotionPanelPayBackListener jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListener = new acns(this);
  protected int h = 2;
  
  public EmotionNeedDownloadAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmotionPanelPayBackListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListener);
  }
  
  public void a()
  {
    super.a();
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    EmotionPanelPayBackListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionPanelPayBackListener);
  }
  
  public void a(int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void b(EmoticonPackage paramEmoticonPackage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
 * JD-Core Version:    0.7.0.1
 */