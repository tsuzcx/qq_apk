package com.tencent.mobileqq.transfile;

public class TranDbRecord$PicDbRecord
{
  public String bigMsgUrl;
  public String bigThumbMsgUrl;
  public int extraFlag;
  public Object extraObject;
  public int fileSizeFlag;
  public boolean isRead;
  public String md5;
  public long msgId;
  public String path;
  public String rawMsgUrl;
  public String serverStoreSource;
  public long size;
  public String thumbMsgUrl;
  public int type;
  public String uin;
  public int uinType;
  public String uuid;
  
  public static String makeDbRecord(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3)
  {
    return TransfileUtile.makeTransFileProtocolData(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt2, paramInt3);
  }
  
  public static String makeDbRecord(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3, String paramString9)
  {
    return TransfileUtile.makeTransFileProtocolData(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt2, paramInt3, paramString9);
  }
  
  public void initFromMsg(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramString.charAt(0) == '\026'))
    {
      String[] arrayOfString = paramString.split("\\|");
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          if ((arrayOfString[i] != null) && (arrayOfString[i].equals("null"))) {
            arrayOfString[i] = null;
          }
          i += 1;
        }
        if (arrayOfString.length >= 1) {
          this.path = arrayOfString[0].trim();
        }
        if (arrayOfString.length >= 2) {
          try
          {
            this.size = Long.parseLong(arrayOfString[1]);
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            this.size = 0L;
            localNumberFormatException1.printStackTrace();
          }
        }
        if (arrayOfString.length >= 3) {
          try
          {
            this.type = Integer.parseInt(arrayOfString[2]);
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            this.type = 0;
            localNumberFormatException2.printStackTrace();
          }
        }
        if (arrayOfString.length >= 4) {
          try
          {
            this.isRead = Boolean.parseBoolean(arrayOfString[3]);
          }
          catch (Exception localException2)
          {
            this.isRead = false;
            localException2.printStackTrace();
          }
        }
        if (arrayOfString.length >= 5) {
          this.uuid = arrayOfString[4];
        }
        if (arrayOfString.length >= 6) {
          this.md5 = arrayOfString[5];
        }
        if (arrayOfString.length >= 7) {
          this.serverStoreSource = arrayOfString[6];
        }
        if (arrayOfString.length >= 8) {
          this.thumbMsgUrl = arrayOfString[7];
        }
        if (arrayOfString.length >= 9) {
          this.bigMsgUrl = arrayOfString[8];
        }
        if (arrayOfString.length >= 10) {
          this.rawMsgUrl = arrayOfString[9];
        }
        if (arrayOfString.length >= 11) {
          try
          {
            this.fileSizeFlag = Integer.parseInt(arrayOfString[10]);
          }
          catch (Exception localException3)
          {
            this.fileSizeFlag = 0;
            localException3.printStackTrace();
          }
        }
        if (arrayOfString.length >= 12) {
          try
          {
            this.extraFlag = Integer.parseInt(arrayOfString[11]);
          }
          catch (Exception localException1)
          {
            this.extraFlag = 0;
            localException1.printStackTrace();
          }
        }
        if (this.extraFlag == 10)
        {
          PicFowardDbRecordData localPicFowardDbRecordData = new PicFowardDbRecordData();
          localPicFowardDbRecordData.initFromMsg(paramString);
          this.extraObject = localPicFowardDbRecordData;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord
 * JD-Core Version:    0.7.0.1
 */