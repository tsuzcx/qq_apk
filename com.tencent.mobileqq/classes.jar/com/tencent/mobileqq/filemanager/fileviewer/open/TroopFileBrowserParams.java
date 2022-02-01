package com.tencent.mobileqq.filemanager.fileviewer.open;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopFileBrowserParams
  extends BaseFileBrowserParams
{
  private QQAppInterface f;
  private Context g;
  private long h;
  private TroopFileStatusInfo i;
  private int j;
  private Bundle k;
  private long l;
  private String m;
  
  public TroopFileBrowserParams(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt)
  {
    super(paramQQAppInterface, paramContext);
    this.f = paramQQAppInterface;
    this.h = paramLong;
    this.i = paramTroopFileStatusInfo;
    this.j = paramInt;
    this.g = paramContext;
  }
  
  private void p()
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    if ((!TextUtils.isEmpty(((TroopFileStatusInfo)localObject).t)) && (this.i.t.endsWith(".mp4")))
    {
      localObject = this.g;
      if ((localObject != null) && ((localObject instanceof SplashActivity))) {
        localObject = "1";
      } else {
        localObject = "3";
      }
      ShortVideoUtils.reportVideoPlay(this.f.getCurrentAccountUin(), String.valueOf(this.h), String.valueOf(0), 1, "3", (String)localObject);
    }
  }
  
  public Intent a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    Object localObject = FileManagerUtil.a(paramTroopFileStatusInfo);
    if (!TextUtils.isEmpty(this.m)) {
      ((FileManagerEntity)localObject).selfUin = this.m;
    }
    long l1 = this.l;
    if (l1 != 0L) {
      ((FileManagerEntity)localObject).lastTime = l1;
    }
    ((FileManagerEntity)localObject).bSend = this.f.getAccount().equals(((FileManagerEntity)localObject).selfUin);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.d(4);
    localForwardFileInfo.b(10006);
    localForwardFileInfo.a(paramTroopFileStatusInfo.k);
    localForwardFileInfo.d(paramTroopFileStatusInfo.t);
    localForwardFileInfo.d(paramTroopFileStatusInfo.i);
    localForwardFileInfo.a(this.h);
    localForwardFileInfo.c(paramTroopFileStatusInfo.c);
    paramTroopFileStatusInfo = new Intent();
    if (this.j == 1)
    {
      localObject = TroopFileManager.a(this.f, this.h).a(this.i.x);
      if (localObject != null) {
        paramTroopFileStatusInfo.putExtra("leftViewText", ((TroopFileInfo)localObject).d);
      }
    }
    paramTroopFileStatusInfo.putExtra("fileinfo", localForwardFileInfo);
    paramTroopFileStatusInfo.putExtra("removemementity", true);
    paramTroopFileStatusInfo.putExtra("forward_from_troop_file", true);
    paramTroopFileStatusInfo.putExtra("not_forward", true);
    paramTroopFileStatusInfo.putExtra("file_browser_extra_params_uin", String.valueOf(this.h));
    l1 = this.l;
    if (l1 != 0L) {
      paramTroopFileStatusInfo.putExtra("last_time", l1);
    }
    paramTroopFileStatusInfo.putExtra("from_type_troop", this.j);
    p();
    return paramTroopFileStatusInfo;
  }
  
  public void a(long paramLong)
  {
    this.l = paramLong;
  }
  
  public void a(Bundle paramBundle)
  {
    this.k = paramBundle;
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.a != null)
    {
      paramBundle.putLong("troopfile_shmsgseq", this.a.shmsgseq);
      paramBundle.putBoolean("is_multi_aio_msg", this.a.isMultiMsg);
      if (this.k.containsKey("FromChatHistoryTab")) {
        paramBundle.putInt("FromChatHistoryTab", this.k.getInt("FromChatHistoryTab", 0));
      }
      if (this.k.containsKey("file_location_pos_entrance_multiseq")) {
        paramBundle.putBoolean("file_location_pos_entrance_multiseq", this.k.getBoolean("file_location_pos_entrance_multiseq", false));
      }
    }
  }
  
  public boolean d()
  {
    return super.d();
  }
  
  protected String e()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = this.i;
    if ((localTroopFileStatusInfo != null) && (!TextUtils.isEmpty(localTroopFileStatusInfo.t))) {
      return this.i.t;
    }
    return "";
  }
  
  protected long f()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = this.i;
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.i;
    }
    return 0L;
  }
  
  protected int g()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = this.i;
    if ((localTroopFileStatusInfo != null) && ((localTroopFileStatusInfo.e == 1) || (this.i.e == 8) || (this.i.e == 0))) {
      return 2;
    }
    return -1;
  }
  
  protected String h()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = this.i;
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.k;
    }
    return "";
  }
  
  public Intent i()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = o();
    if (localTroopFileStatusInfo == null) {
      return null;
    }
    return a(localTroopFileStatusInfo);
  }
  
  boolean j()
  {
    if ((this.i.e != 10) && (this.i.e != 9)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(this.i.a);
      localStringBuilder.append(" status:");
      localStringBuilder.append(this.i.e);
      localStringBuilder.append(" resume");
      QLog.i("FileVideo", 1, localStringBuilder.toString());
    }
    TroopFileTransferManager.a(this.h).d(this.i.a);
    return true;
  }
  
  boolean k()
  {
    if (this.i == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileVideo", 1, "mTroopFileInfo is null, return false,(check why is here!)");
      }
      return false;
    }
    int n = FileManagerUtil.c(e());
    StringBuilder localStringBuilder;
    if (n != 2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id:");
        localStringBuilder.append(this.i.a);
        localStringBuilder.append(" type is:");
        localStringBuilder.append(n);
        localStringBuilder.append(" use old filebrowser:");
        QLog.i("FileVideo", 1, localStringBuilder.toString());
      }
      return false;
    }
    if (this.i.e == 12)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id:");
        localStringBuilder.append(this.i.a);
        localStringBuilder.append(" is deleted, return false,(check why is here!)");
        QLog.w("FileVideo", 1, localStringBuilder.toString());
      }
      return false;
    }
    if ((this.i.e != 4) && (this.i.e != 5))
    {
      if (TroopFileInfo.FileStatus.a(this.i.e))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("id:");
          localStringBuilder.append(this.i.a);
          localStringBuilder.append(" status:");
          localStringBuilder.append(this.i.e);
          localStringBuilder.append(" use old browser!");
          QLog.i("FileVideo", 1, localStringBuilder.toString());
        }
        return false;
      }
      if ((!FileUtil.b(this.i.k)) && (!QFileUtils.a(this.f)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileVideo", 1, "use new filevideo browser switch is off!");
        }
        return false;
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(this.i.a);
      localStringBuilder.append(" is forwarding, return false,(check why is here!)");
      QLog.w("FileVideo", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public FileManagerEntity n()
  {
    Object localObject = o();
    if (localObject == null) {
      return null;
    }
    localObject = FileManagerUtil.a((TroopFileStatusInfo)localObject);
    if (!TextUtils.isEmpty(this.m)) {
      ((FileManagerEntity)localObject).selfUin = this.m;
    }
    long l1 = this.l;
    if (l1 != 0L) {
      ((FileManagerEntity)localObject).lastTime = l1;
    }
    ((FileManagerEntity)localObject).bSend = this.f.getAccount().equals(((FileManagerEntity)localObject).selfUin);
    return localObject;
  }
  
  TroopFileStatusInfo o()
  {
    boolean bool = FileUtil.d(this.i.k);
    String str = "";
    if (!bool)
    {
      TroopFileTransferManager.a(this.f, this.h).o();
      int n = this.i.e;
      if ((n == 2) || (n == 3))
      {
        n = this.i.k.lastIndexOf("/") + 1;
        if (n < this.i.k.length()) {
          str = this.i.k.substring(n, this.i.k.length() - 1);
        }
        str = String.format(this.g.getString(2131895088), new Object[] { TroopFileUtils.a(str) });
        TroopFileError.a(this.g, str);
        return null;
      }
    }
    if (!TextUtils.isEmpty(this.i.t)) {
      str = this.i.t;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
    localTroopFileStatusInfo.t = str;
    localTroopFileStatusInfo.k = this.i.k;
    localTroopFileStatusInfo.i = this.i.i;
    localTroopFileStatusInfo.j = this.i.j;
    localTroopFileStatusInfo.a = this.i.a;
    localTroopFileStatusInfo.c = this.i.c;
    localTroopFileStatusInfo.d = this.h;
    localTroopFileStatusInfo.u = this.i.u;
    localTroopFileStatusInfo.r = this.i.r;
    localTroopFileStatusInfo.s = this.i.s;
    localTroopFileStatusInfo.l = this.i.l;
    localTroopFileStatusInfo.m = this.i.m;
    localTroopFileStatusInfo.n = this.i.n;
    localTroopFileStatusInfo.e = this.i.e;
    localTroopFileStatusInfo.A = this.i.A;
    localTroopFileStatusInfo.B = this.i.B;
    localTroopFileStatusInfo.C = this.i.C;
    localTroopFileStatusInfo.D = this.i.D;
    localTroopFileStatusInfo.E = this.i.E;
    localTroopFileStatusInfo.F = this.i.F;
    TroopFileManager.a(this.f, this.h).b(this.i.a);
    return localTroopFileStatusInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.open.TroopFileBrowserParams
 * JD-Core Version:    0.7.0.1
 */