package com.tencent.mobileqq.music;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;

public abstract interface IQQPlayerService
  extends IInterface
{
  public abstract String a(int paramInt, String paramString);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(Intent paramIntent);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(IQQPlayerCallback paramIQQPlayerCallback);
  
  public abstract void a(String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt);
  
  public abstract boolean a(String paramString);
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(IQQPlayerCallback paramIQQPlayerCallback);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract boolean f();
  
  public abstract int g();
  
  public abstract int h();
  
  public abstract int i();
  
  public abstract int j();
  
  public abstract SongInfo k();
  
  public abstract SongInfo l();
  
  public abstract int m();
  
  public abstract int n();
  
  public abstract SongInfo[] o();
  
  public abstract Intent p();
  
  public abstract Bundle q();
  
  public abstract String r();
  
  public abstract int s();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.IQQPlayerService
 * JD-Core Version:    0.7.0.1
 */