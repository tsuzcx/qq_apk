package com.tencent.mobileqq.qqgift.data.service;

public class GiftListData
{
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public boolean e = false;
  
  public GiftListData() {}
  
  public GiftListData(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  public static GiftListData a()
  {
    GiftListData localGiftListData = new GiftListData();
    localGiftListData.a = 1;
    return localGiftListData;
  }
  
  public String a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sceneId:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("panelType:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("source:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("gameType:");
    ((StringBuilder)localObject).append(this.c);
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (this.e)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("anchorID:");
      ((StringBuilder)localObject).append(this.d);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.data.service.GiftListData
 * JD-Core Version:    0.7.0.1
 */