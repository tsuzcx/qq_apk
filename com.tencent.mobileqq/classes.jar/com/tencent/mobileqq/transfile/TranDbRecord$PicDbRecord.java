package com.tencent.mobileqq.transfile;

public class TranDbRecord$PicDbRecord
{
  public static int EXTRA_FLAG_FOWARD_PHOTO = 10;
  public static int EXTRA_FLAG_SEND_PHOTO;
  public static int EXTRA_FLAG_SEND_RAW_PHOTO = EXTRA_FLAG_SEND_PHOTO + 1;
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
    Object localObject;
    if ((paramString != null) && (paramString.length() > 0) && (paramString.charAt(0) == '\026'))
    {
      localObject = paramString.split("\\|");
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          if ((localObject[i] != null) && (localObject[i].equals("null"))) {
            localObject[i] = null;
          }
          i += 1;
        }
        if (localObject.length >= 1) {
          this.path = localObject[0].trim();
        }
        if (localObject.length < 2) {}
      }
    }
    try
    {
      this.size = Long.parseLong(localObject[1]);
      if (localObject.length < 3) {}
    }
    catch (NumberFormatException localException3)
    {
      try
      {
        this.type = Integer.parseInt(localObject[2]);
        if (localObject.length < 4) {}
      }
      catch (NumberFormatException localException3)
      {
        try
        {
          this.isRead = Boolean.parseBoolean(localObject[3]);
          if (localObject.length >= 5) {
            this.uuid = localObject[4];
          }
          if (localObject.length >= 6) {
            this.md5 = localObject[5];
          }
          if (localObject.length >= 7) {
            this.serverStoreSource = localObject[6];
          }
          if (localObject.length >= 8) {
            this.thumbMsgUrl = localObject[7];
          }
          if (localObject.length >= 9) {
            this.bigMsgUrl = localObject[8];
          }
          if (localObject.length >= 10) {
            this.rawMsgUrl = localObject[9];
          }
          if (localObject.length < 11) {}
        }
        catch (Exception localException3)
        {
          try
          {
            this.fileSizeFlag = Integer.parseInt(localObject[10]);
            if (localObject.length < 12) {}
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                this.extraFlag = Integer.parseInt(localObject[11]);
                if (this.extraFlag == EXTRA_FLAG_FOWARD_PHOTO)
                {
                  localObject = new PicFowardDbRecordData();
                  ((PicFowardDbRecordData)localObject).initFromMsg(paramString);
                  this.extraObject = localObject;
                }
                return;
                localNumberFormatException1 = localNumberFormatException1;
                this.size = 0L;
                localNumberFormatException1.printStackTrace();
                continue;
                localNumberFormatException2 = localNumberFormatException2;
                this.type = 0;
                localNumberFormatException2.printStackTrace();
                continue;
                localException2 = localException2;
                this.isRead = false;
                localException2.printStackTrace();
              }
              localException3 = localException3;
              this.fileSizeFlag = 0;
              localException3.printStackTrace();
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                this.extraFlag = 0;
                localException1.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord
 * JD-Core Version:    0.7.0.1
 */