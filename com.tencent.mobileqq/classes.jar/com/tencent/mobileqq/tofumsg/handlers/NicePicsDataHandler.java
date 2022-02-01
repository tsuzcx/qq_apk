package com.tencent.mobileqq.tofumsg.handlers;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tofumsg.TofuDataBaseHandler;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.PhotoWall.oidb_PhotoWall.CommRsp;
import tencent.im.oidb.PhotoWall.oidb_PhotoWall.GetPhotoIndexListRsp;
import tencent.im.oidb.PhotoWall.oidb_PhotoWall.PhotoIndexInfoEx;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;

public class NicePicsDataHandler
  extends TofuDataBaseHandler
{
  public NicePicsDataHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private JSONObject a(oidb_PhotoWall.GetPhotoIndexListRsp paramGetPhotoIndexListRsp)
  {
    int i;
    if (paramGetPhotoIndexListRsp.next_offset.has()) {
      i = paramGetPhotoIndexListRsp.next_offset.get();
    } else {
      i = -1;
    }
    int j;
    if (paramGetPhotoIndexListRsp.uptime.has()) {
      j = paramGetPhotoIndexListRsp.uptime.get();
    } else {
      j = 0;
    }
    if (paramGetPhotoIndexListRsp.photo_list.has()) {
      paramGetPhotoIndexListRsp = paramGetPhotoIndexListRsp.photo_list.get();
    } else {
      paramGetPhotoIndexListRsp = null;
    }
    int k;
    if ((paramGetPhotoIndexListRsp != null) && (paramGetPhotoIndexListRsp.size() > 0))
    {
      localObject = (oidb_PhotoWall.PhotoIndexInfoEx)paramGetPhotoIndexListRsp.get(0);
      paramGetPhotoIndexListRsp = ((oidb_PhotoWall.PhotoIndexInfoEx)localObject).filekey.get();
      k = ((oidb_PhotoWall.PhotoIndexInfoEx)localObject).ctime.get();
    }
    else
    {
      paramGetPhotoIndexListRsp = "";
      k = 0;
    }
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("nextOffset", i);
    ((JSONObject)localObject).put("upTime", j);
    ((JSONObject)localObject).put("lastFileKey", paramGetPhotoIndexListRsp);
    ((JSONObject)localObject).put("lastCTime", k);
    if (QLog.isColorLevel()) {
      QLog.i("Tofu_NicePicsDataHandler", 2, String.format("updateItemFromRsp.parseRsp data=%s", new Object[] { localObject }));
    }
    return localObject;
  }
  
  public int a()
  {
    return 10;
  }
  
  public boolean a(TofuItem paramTofuItem, boolean paramBoolean, long paramLong, oidb_0xe61.BeancurdCubeInfo paramBeancurdCubeInfo)
  {
    boolean bool4 = super.a(paramTofuItem, paramBoolean, paramLong, paramBeancurdCubeInfo);
    if (bool4) {
      paramBeancurdCubeInfo = new oidb_PhotoWall.GetPhotoIndexListRsp();
    }
    for (;;)
    {
      try
      {
        paramBeancurdCubeInfo.mergeFrom(paramTofuItem.bytesFromServer);
        oidb_PhotoWall.CommRsp localCommRsp = (oidb_PhotoWall.CommRsp)paramBeancurdCubeInfo.comm_rsp.get();
        if ((localCommRsp == null) || (!localCommRsp.result.has())) {
          break label297;
        }
        i = localCommRsp.result.get();
        if (!paramBeancurdCubeInfo.base_time_photo_count.has()) {
          break label304;
        }
        j = (int)paramBeancurdCubeInfo.base_time_photo_count.get();
        if ((i != 0) || (j <= 0)) {
          break label316;
        }
        paramBeancurdCubeInfo = a(paramBeancurdCubeInfo);
        if (paramBeancurdCubeInfo != null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        if (!paramBoolean) {
          break label310;
        }
        boolean bool2 = paramBoolean;
        boolean bool3 = paramBoolean;
        try
        {
          paramBeancurdCubeInfo = paramBeancurdCubeInfo.toString();
          bool2 = paramBoolean;
          bool3 = paramBoolean;
          paramTofuItem.msg = paramBeancurdCubeInfo;
          bool2 = paramBoolean;
          bool3 = paramBoolean;
          bool1 = paramBoolean;
          if (!QLog.isColorLevel()) {
            break label283;
          }
          bool2 = paramBoolean;
          bool3 = paramBoolean;
          QLog.i("Tofu_NicePicsDataHandler", 2, String.format("updateItemFromRsp resultCode=%d picCnt=%d parseSuc=%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(paramBoolean) }));
          bool1 = paramBoolean;
        }
        catch (Exception paramTofuItem)
        {
          bool1 = bool2;
        }
        catch (InvalidProtocolBufferMicroException paramTofuItem)
        {
          bool1 = bool3;
        }
        QLog.d("Tofu_NicePicsDataHandler", 1, "updateItemFromRsp exception", paramTofuItem);
      }
      catch (Exception paramTofuItem)
      {
        bool1 = false;
        QLog.d("Tofu_NicePicsDataHandler", 1, "updateItemFromRsp exception", paramTofuItem);
      }
      catch (InvalidProtocolBufferMicroException paramTofuItem)
      {
        bool1 = false;
      }
      break label283;
      boolean bool1 = false;
      label283:
      return (bool4) && (bool1);
      label297:
      int i = -2147483648;
      continue;
      label304:
      int j = 0;
      continue;
      label310:
      paramBeancurdCubeInfo = null;
      continue;
      label316:
      paramBoolean = false;
    }
  }
  
  /* Error */
  public byte[] b(TofuItem paramTofuItem)
  {
    // Byte code:
    //   0: ldc 69
    //   2: astore 8
    //   4: iconst_0
    //   5: istore 4
    //   7: new 71	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: getfield 159	com/tencent/mobileqq/tofumsg/TofuItem:msg	Ljava/lang/String;
    //   15: invokespecial 186	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore 11
    //   20: aload 11
    //   22: ldc 76
    //   24: iconst_0
    //   25: invokevirtual 190	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   28: istore_2
    //   29: aload 11
    //   31: ldc 82
    //   33: iconst_0
    //   34: invokevirtual 190	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   37: istore_3
    //   38: aload 8
    //   40: astore 9
    //   42: aload 11
    //   44: ldc 84
    //   46: ldc 69
    //   48: invokevirtual 194	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 10
    //   53: aload 10
    //   55: astore 9
    //   57: aload 10
    //   59: astore 8
    //   61: aload 11
    //   63: ldc 89
    //   65: iconst_0
    //   66: invokevirtual 190	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   69: istore 5
    //   71: aload 10
    //   73: astore 8
    //   75: iload 5
    //   77: istore 4
    //   79: goto +66 -> 145
    //   82: astore 10
    //   84: aload 9
    //   86: astore 8
    //   88: aload 10
    //   90: astore 9
    //   92: goto +24 -> 116
    //   95: astore 9
    //   97: goto +38 -> 135
    //   100: astore 9
    //   102: goto +12 -> 114
    //   105: astore 9
    //   107: goto +26 -> 133
    //   110: astore 9
    //   112: iconst_0
    //   113: istore_2
    //   114: iconst_0
    //   115: istore_3
    //   116: ldc 96
    //   118: iconst_1
    //   119: ldc 196
    //   121: aload 9
    //   123: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: goto +19 -> 145
    //   129: astore 9
    //   131: iconst_0
    //   132: istore_2
    //   133: iconst_0
    //   134: istore_3
    //   135: ldc 96
    //   137: iconst_1
    //   138: ldc 196
    //   140: aload 9
    //   142: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: new 198	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq
    //   148: dup
    //   149: invokespecial 199	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:<init>	()V
    //   152: astore 9
    //   154: aload 9
    //   156: getfield 202	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   159: aload_1
    //   160: getfield 206	com/tencent/mobileqq/tofumsg/TofuItem:frdUin	J
    //   163: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   166: aload 9
    //   168: getfield 213	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:offset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   171: iload_2
    //   172: invokevirtual 216	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   175: aload 9
    //   177: getfield 219	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   180: iconst_2
    //   181: invokevirtual 216	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   184: aload 9
    //   186: getfield 220	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:uptime	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: iload_3
    //   190: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   193: invokestatic 227	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   196: invokevirtual 231	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   199: invokevirtual 236	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   202: invokestatic 241	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   205: invokevirtual 244	java/lang/Long:longValue	()J
    //   208: lstore 6
    //   210: aload 9
    //   212: getfield 247	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:opuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   215: lload 6
    //   217: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   220: aload 9
    //   222: getfield 250	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:last_filekey	Lcom/tencent/mobileqq/pb/PBStringField;
    //   225: aload 8
    //   227: invokevirtual 252	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   230: aload 9
    //   232: getfield 255	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:last_ctime	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   235: iload 4
    //   237: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   240: aload 9
    //   242: getfield 258	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:base_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   245: aload_1
    //   246: getfield 261	com/tencent/mobileqq/tofumsg/TofuItem:lastPullTsSvr	J
    //   249: invokevirtual 210	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   252: aload 9
    //   254: invokevirtual 265	tencent/im/oidb/PhotoWall/oidb_PhotoWall$GetPhotoIndexListReq:toByteArray	()[B
    //   257: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	NicePicsDataHandler
    //   0	258	1	paramTofuItem	TofuItem
    //   28	144	2	i	int
    //   37	153	3	j	int
    //   5	231	4	k	int
    //   69	7	5	m	int
    //   208	8	6	l	long
    //   2	224	8	localObject1	Object
    //   40	51	9	localObject2	Object
    //   95	1	9	localJSONException1	JSONException
    //   100	1	9	localException1	Exception
    //   105	1	9	localJSONException2	JSONException
    //   110	12	9	localException2	Exception
    //   129	12	9	localJSONException3	JSONException
    //   152	101	9	localGetPhotoIndexListReq	tencent.im.oidb.PhotoWall.oidb_PhotoWall.GetPhotoIndexListReq
    //   51	21	10	str	String
    //   82	7	10	localException3	Exception
    //   18	44	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   42	53	82	java/lang/Exception
    //   61	71	82	java/lang/Exception
    //   42	53	95	org/json/JSONException
    //   61	71	95	org/json/JSONException
    //   29	38	100	java/lang/Exception
    //   29	38	105	org/json/JSONException
    //   7	29	110	java/lang/Exception
    //   7	29	129	org/json/JSONException
  }
  
  public String c(TofuItem paramTofuItem)
  {
    Object localObject2 = paramTofuItem.bytesFromServer;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject1 = localObject3;
      if (paramTofuItem.bytesFromServer.length > 0) {
        localObject1 = new oidb_PhotoWall.GetPhotoIndexListRsp();
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        ((oidb_PhotoWall.GetPhotoIndexListRsp)localObject1).mergeFrom(paramTofuItem.bytesFromServer);
        int i = (int)((oidb_PhotoWall.GetPhotoIndexListRsp)localObject1).base_time_photo_count.get();
        long l = ((oidb_PhotoWall.GetPhotoIndexListRsp)localObject1).uptime.get();
        localObject2 = ((oidb_PhotoWall.GetPhotoIndexListRsp)localObject1).photo_list.get();
        if (((List)localObject2).size() <= 0) {
          break label389;
        }
        localObject1 = ((oidb_PhotoWall.PhotoIndexInfoEx)((List)localObject2).get(0)).burl.get();
        if (((List)localObject2).size() <= 1) {
          break label395;
        }
        localObject2 = ((oidb_PhotoWall.PhotoIndexInfoEx)((List)localObject2).get(1)).burl.get();
        localJSONObject.put("key_nice_pics_count", i);
        localJSONObject.put("key_nice_pics_ts", l);
        localJSONObject.put("key_nice_pics_url_1", localObject1);
        localJSONObject.put("key_nice_pics_url_2", localObject2);
        localJSONObject.put("key_frd_uin", paramTofuItem.frdUin);
        localObject1 = localJSONObject.toString();
      }
      catch (Exception paramTofuItem)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getBusDataFromRspBytes ex=");
        ((StringBuilder)localObject1).append(paramTofuItem.getMessage());
        QLog.d("Tofu_NicePicsDataHandler", 1, ((StringBuilder)localObject1).toString(), paramTofuItem);
        localObject1 = localObject3;
      }
      catch (JSONException paramTofuItem)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getBusDataFromRspBytes ex=");
        ((StringBuilder)localObject1).append(paramTofuItem.getMessage());
        QLog.d("Tofu_NicePicsDataHandler", 1, ((StringBuilder)localObject1).toString(), paramTofuItem);
        localObject1 = localObject3;
      }
      catch (InvalidProtocolBufferMicroException paramTofuItem)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getBusDataFromRspBytes ex=");
        ((StringBuilder)localObject1).append(paramTofuItem.getMessage());
        QLog.d("Tofu_NicePicsDataHandler", 1, ((StringBuilder)localObject1).toString(), paramTofuItem);
        localObject1 = localObject3;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Tofu_NicePicsDataHandler", 2, String.format("getBusDataFromRspBytes %s", new Object[] { localObject1 }));
      }
      return localObject1;
      label389:
      localObject1 = null;
      continue;
      label395:
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.handlers.NicePicsDataHandler
 * JD-Core Version:    0.7.0.1
 */