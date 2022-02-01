package com.tencent.mobileqq.emosm.favroaming;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import java.util.Map;

public abstract interface IEmoticonFromGroupManager
{
  public abstract int a();
  
  public abstract Drawable a(Drawable paramDrawable, int paramInt);
  
  public abstract Drawable a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt1, int paramInt2, Drawable paramDrawable);
  
  public abstract EmoticonFromGroupEntity a(MessageRecord paramMessageRecord);
  
  public abstract String a(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(Context paramContext, MessageForPic paramMessageForPic, View paramView);
  
  public abstract void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity);
  
  public abstract void a(List<MessageRecord> paramList);
  
  public abstract boolean a(List<CustomEmotionData> paramList, String paramString);
  
  public abstract List<EmoticonFromGroupEntity> b();
  
  public abstract Map<String, List<EmoticonFromGroupEntity>> b(List<EmoticonFromGroupEntity> paramList);
  
  public abstract void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity);
  
  public abstract void b(MessageRecord paramMessageRecord);
  
  public abstract void c(MessageRecord paramMessageRecord);
  
  public abstract void c(List<EmoticonFromGroupEntity> paramList);
  
  public abstract void d(List<EmoticonFromGroupEntity> paramList);
  
  public abstract boolean d(EmoticonFromGroupEntity paramEmoticonFromGroupEntity);
  
  public abstract void e(List<EmoticonFromGroupEntity> paramList);
  
  public abstract <T extends MessageRecord> T f(EmoticonFromGroupEntity paramEmoticonFromGroupEntity);
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager
 * JD-Core Version:    0.7.0.1
 */