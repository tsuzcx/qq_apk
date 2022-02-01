package com.tencent.mobileqq.filemanager.fileassistant.forward;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.qphone.base.util.BaseApplication;

public class QFileAssistantForwardManager
{
  private QQAppInterface a;
  private String b;
  private boolean c = false;
  
  public QFileAssistantForwardManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = QFileAssistantUtils.b(this.a);
  }
  
  private void b(String paramString)
  {
    if (!this.c) {
      return;
    }
    String str = this.a.getApp().getString(2131889669);
    if (TextUtils.isEmpty(paramString)) {
      paramString = str;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QFileAssistantForwardManager.1(this, paramString), 300L);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    FileManagerEngine localFileManagerEngine = this.a.getFileManagerEngine();
    if (paramFileManagerEntity.getCloudType() == 4)
    {
      long l1 = paramFileManagerEntity.TroopUin;
      long l2 = Long.valueOf(this.b).longValue();
      localFileManagerEngine.a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.strFilePath, l1, l2, 0, 0);
    }
    else
    {
      localFileManagerEngine.a(paramFileManagerEntity.nSessionId, this.a.getAccount(), this.b, 0, true);
    }
    b("");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    localBundle.putBoolean("forward _key_nojump", true);
    localBundle.putInt("uintype", 0);
    localBundle.putString("uin", this.b);
    localBundle.putString("uinname", BaseApplicationImpl.getContext().getString(2131896189));
    localBundle.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.b.intValue());
    localIntent.putExtras(localBundle);
    ForwardUtils.a(this.a, null, BaseApplicationImpl.getContext(), localIntent, null);
    b("");
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager
 * JD-Core Version:    0.7.0.1
 */