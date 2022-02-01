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
  
  public abstract <T extends MessageRecord> T a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity);
  
  public abstract String a(String paramString1, int paramInt, String paramString2);
  
  public abstract List<EmoticonFromGroupEntity> a();
  
  public abstract Map<String, List<EmoticonFromGroupEntity>> a(List<EmoticonFromGroupEntity> paramList);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, MessageForPic paramMessageForPic, View paramView);
  
  public abstract void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity);
  
  public abstract void a(MessageRecord paramMessageRecord);
  
  public abstract void a(List<MessageRecord> paramList);
  
  public abstract boolean a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity);
  
  public abstract boolean a(List<CustomEmotionData> paramList, String paramString);
  
  public abstract void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity);
  
  public abstract void b(MessageRecord paramMessageRecord);
  
  public abstract void b(List<EmoticonFromGroupEntity> paramList);
  
  public abstract void c(List<EmoticonFromGroupEntity> paramList);
  
  public abstract void d(List<EmoticonFromGroupEntity> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager
 * JD-Core Version:    0.7.0.1
 */