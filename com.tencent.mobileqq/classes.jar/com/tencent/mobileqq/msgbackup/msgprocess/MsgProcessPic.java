package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MsgProcessPic
  extends MsgProcessRichMedia<MessageForPic>
{
  public MsgProcessPic(MessageForPic paramMessageForPic)
  {
    super(paramMessageForPic);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public List<MsgBackupResEntity> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = ((MessageForPic)this.a).fileSizeFlag;
    int m = 0;
    int k;
    if (i == 1) {
      k = 1;
    } else {
      k = 0;
    }
    int[] arrayOfInt;
    if (k != 0)
    {
      arrayOfInt = new int[3];
      int[] tmp46_44 = arrayOfInt;
      tmp46_44[0] = 1;
      int[] tmp50_46 = tmp46_44;
      tmp50_46[1] = 2;
      int[] tmp54_50 = tmp50_46;
      tmp54_50[2] = 3;
      tmp54_50;
    }
    else
    {
      arrayOfInt = new int[2];
      int[] tmp69_67 = arrayOfInt;
      tmp69_67[0] = 2;
      int[] tmp73_69 = tmp69_67;
      tmp73_69[1] = 3;
      tmp73_69;
    }
    int n = arrayOfInt.length;
    int j;
    for (i = 0; m < n; i = j)
    {
      int i1 = arrayOfInt[m];
      MsgBackupResEntity localMsgBackupResEntity = a();
      localMsgBackupResEntity.msgSubType = i1;
      if (i1 == 1)
      {
        localObject = "chatraw";
      }
      else if (i1 == 2)
      {
        localObject = "chatimg";
      }
      else
      {
        j = i;
        if (i1 != 3) {
          break label392;
        }
        localObject = "chatthumb";
      }
      Object localObject = ((MessageForPic)this.a).getFilePath((String)localObject);
      if (!a((String)localObject))
      {
        j = i;
      }
      else
      {
        localMsgBackupResEntity.filePath = ((String)localObject);
        a((String)localObject, localMsgBackupResEntity);
        localObject = a(i1);
        ((HashMap)localObject).put("selfuin", ((MessageForPic)this.a).selfuin);
        if (((MessageForPic)this.a).uuid != null) {
          ((HashMap)localObject).put("uuid", ((MessageForPic)this.a).uuid.toUpperCase());
        }
        if (((MessageForPic)this.a).md5 != null) {
          ((HashMap)localObject).put("md5", ((MessageForPic)this.a).md5.toUpperCase());
        }
        if (k != 0) {
          ((HashMap)localObject).put("isOriginal", "1");
        } else {
          ((HashMap)localObject).put("isOriginal", "0");
        }
        j = i;
        if (((MessageForPic)this.a).checkGif()) {
          if ((i1 != 1) && (i1 != 2))
          {
            j = i;
            if (i != 0)
            {
              ((HashMap)localObject).put("hasOriginGif", "1");
              j = i;
            }
          }
          else
          {
            j = 1;
          }
        }
        localMsgBackupResEntity.extraDataStr = a((Map)localObject);
        QLog.isColorLevel();
        localArrayList.add(localMsgBackupResEntity);
      }
      label392:
      m += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    MessageForPic localMessageForPic = (MessageForPic)this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("packMsg uinType:");
    localStringBuilder.append(localMessageForPic.istroop);
    a(localStringBuilder.toString());
    localMessageForPic.richText = localMessageForPic.getRichText();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.msgprocess.MsgProcessPic
 * JD-Core Version:    0.7.0.1
 */