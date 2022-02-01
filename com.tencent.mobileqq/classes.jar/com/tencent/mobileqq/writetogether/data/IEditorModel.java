package com.tencent.mobileqq.writetogether.data;

import com.tencent.mobileqq.easysync2.AText;
import com.tencent.mobileqq.easysync2.AttribPool;
import com.tencent.mobileqq.writetogether.client.IEditorController;
import com.tencent.mobileqq.writetogether.client.IPartChangeListener;
import com.tencent.mobileqq.writetogether.client.UserStateController;
import com.tencent.util.Pair;
import java.util.List;

public abstract interface IEditorModel
  extends LocalATextGetter
{
  public abstract int a();
  
  public abstract long a();
  
  public abstract AttribPool a();
  
  public abstract CreateDocParam a();
  
  public abstract DocMetaData a();
  
  public abstract Pair<Integer, Integer> a();
  
  public abstract String a();
  
  public abstract String a(String paramString);
  
  public abstract List<UserEditInfo> a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong);
  
  public abstract void a(AText paramAText);
  
  public abstract void a(AttribPool paramAttribPool);
  
  public abstract void a(IEditorController paramIEditorController);
  
  public abstract void a(IPartChangeListener paramIPartChangeListener);
  
  public abstract void a(UserStateController paramUserStateController);
  
  public abstract void a(CursorManager paramCursorManager);
  
  public abstract void a(DocMetaData paramDocMetaData);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString, long paramLong, UserEditInfo paramUserEditInfo);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void a(List<EditUserHistory> paramList);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract int b();
  
  public abstract String b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(String paramString);
  
  public abstract String c();
  
  public abstract String d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.data.IEditorModel
 * JD-Core Version:    0.7.0.1
 */