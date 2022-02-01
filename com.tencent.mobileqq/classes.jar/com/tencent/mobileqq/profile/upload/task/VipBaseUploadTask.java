package com.tencent.mobileqq.profile.upload.task;

import android.text.TextUtils;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class VipBaseUploadTask
{
  protected String d;
  protected Object e = null;
  protected int f;
  protected String g = "";
  public byte[] h = null;
  public boolean i = false;
  public int j = 6;
  public int k = 0;
  public String l;
  public int m;
  public String n = "mqq";
  public Map<String, String> o = null;
  public String p;
  public byte[] q;
  public long r;
  protected byte[] s;
  protected String t;
  protected String u;
  protected int v = -1;
  protected IUploadTaskCallback w;
  protected IUploadTaskCallback x = new VipBaseUploadTask.1(this);
  protected AbstractUploadTask y;
  protected volatile int z = -10001;
  
  public VipBaseUploadTask() {}
  
  public VipBaseUploadTask(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    this.r = paramLong;
    this.t = paramString;
    this.u = VipUploadUtils.a(paramString);
    this.v = d();
    this.s = paramArrayOfByte;
    this.w = this.x;
  }
  
  public final Object a()
  {
    return this.e;
  }
  
  protected abstract void a(int paramInt, Object... paramVarArgs);
  
  public final String b()
  {
    return this.g;
  }
  
  protected void c()
  {
    if (this.y != null)
    {
      if (!e()) {
        return;
      }
      f();
      g();
      return;
    }
    throw new NullPointerException("Are you forget call buildTask()?");
  }
  
  protected int d()
  {
    Object localObject2 = this.t;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    return ((StringBuilder)localObject2).toString().hashCode();
  }
  
  protected boolean e()
  {
    if (this.s != null)
    {
      byte[] arrayOfByte = this.q;
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        return true;
      }
    }
    this.x.onUploadError(this.y, -3, "invalid login data");
    return false;
  }
  
  protected void f()
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(this.d)) {
      localHashMap.put("task_state", this.d);
    }
    if (!TextUtils.isEmpty(this.y.uiRefer)) {
      localHashMap.put("business_refer", this.y.uiRefer);
    }
    this.y.transferData = localHashMap;
  }
  
  protected boolean g()
  {
    if (TextUtils.isEmpty(this.y.uploadFilePath))
    {
      this.x.onUploadError(this.y, -1, "no file path!");
      return false;
    }
    File localFile = new File(this.y.uploadFilePath);
    if ((localFile.exists()) && (localFile.length() != 0L) && (!localFile.isDirectory()))
    {
      this.y.transferData.put("task_state", "running_task");
      return UploadServiceBuilder.getInstance().upload(this.y);
    }
    this.x.onUploadError(this.y, -2, "file is not exist or empty!");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipBaseUploadTask
 * JD-Core Version:    0.7.0.1
 */