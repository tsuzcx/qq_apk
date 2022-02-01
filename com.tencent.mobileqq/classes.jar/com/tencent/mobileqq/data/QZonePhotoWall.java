package com.tencent.mobileqq.data;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QZonePhotoWall
  extends Entity
{
  public String attachInfo;
  @notColumn
  public int curListSize;
  public int hasMore;
  public int totalPic;
  @unique
  public String uin;
  public byte[] vPhotoIds;
  public byte[] vPhotoTimes;
  public byte[] vPhotoUrls;
  
  private void packPhotoWallData(String paramString, ArrayList<PhotoWall> paramArrayList)
  {
    Object localObject1 = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = unpackPhotoWallData();; paramString = (String)localObject1)
    {
      paramString.addAll(paramArrayList);
      Object localObject2 = new ArrayList();
      localObject1 = new ArrayList();
      paramArrayList = new ArrayList();
      Object localObject3 = paramString.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        PhotoWall localPhotoWall = (PhotoWall)((Iterator)localObject3).next();
        ((ArrayList)localObject2).add(localPhotoWall.photoId);
        ((ArrayList)localObject1).add(Long.valueOf(localPhotoWall.ctime));
        paramArrayList.add(localPhotoWall.photoUrls);
      }
      localObject3 = Parcel.obtain();
      ((Parcel)localObject3).setDataPosition(0);
      ((Parcel)localObject3).writeList((List)localObject2);
      this.vPhotoIds = ((Parcel)localObject3).marshall();
      ((Parcel)localObject3).recycle();
      localObject2 = Parcel.obtain();
      ((Parcel)localObject2).setDataPosition(0);
      ((Parcel)localObject2).writeList((List)localObject1);
      this.vPhotoTimes = ((Parcel)localObject2).marshall();
      ((Parcel)localObject2).recycle();
      localObject1 = Parcel.obtain();
      ((Parcel)localObject1).setDataPosition(0);
      ((Parcel)localObject1).writeList(paramArrayList);
      this.vPhotoUrls = ((Parcel)localObject1).marshall();
      ((Parcel)localObject1).recycle();
      this.curListSize = paramString.size();
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("QZonePhotoWall totalPic:").append(this.totalPic);
    localStringBuilder.append(" hasMore:").append(this.hasMore);
    localStringBuilder.append(" photoWallSize:").append(this.curListSize);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public ArrayList<PhotoWall> unpackPhotoWallData()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: new 26	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 27	java/util/ArrayList:<init>	()V
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 98	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoIds	[B
    //   19: ifnull +486 -> 505
    //   22: invokestatic 84	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   25: astore_3
    //   26: aload_3
    //   27: aload_0
    //   28: getfield 98	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoIds	[B
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 98	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoIds	[B
    //   36: arraylength
    //   37: invokevirtual 146	android/os/Parcel:unmarshall	([BII)V
    //   40: aload_3
    //   41: iconst_0
    //   42: invokevirtual 88	android/os/Parcel:setDataPosition	(I)V
    //   45: aload_3
    //   46: aload_0
    //   47: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: invokevirtual 158	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   53: invokevirtual 162	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   56: astore_2
    //   57: aload_3
    //   58: invokevirtual 101	android/os/Parcel:recycle	()V
    //   61: aload_0
    //   62: getfield 103	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoTimes	[B
    //   65: ifnull +435 -> 500
    //   68: invokestatic 84	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   71: astore 4
    //   73: aload 4
    //   75: aload_0
    //   76: getfield 103	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoTimes	[B
    //   79: iconst_0
    //   80: aload_0
    //   81: getfield 103	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoTimes	[B
    //   84: arraylength
    //   85: invokevirtual 146	android/os/Parcel:unmarshall	([BII)V
    //   88: aload 4
    //   90: iconst_0
    //   91: invokevirtual 88	android/os/Parcel:setDataPosition	(I)V
    //   94: aload 4
    //   96: aload_0
    //   97: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
    //   100: invokevirtual 158	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   103: invokevirtual 162	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   106: astore_3
    //   107: aload 4
    //   109: invokevirtual 101	android/os/Parcel:recycle	()V
    //   112: aload_0
    //   113: getfield 105	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoUrls	[B
    //   116: ifnull +378 -> 494
    //   119: aload 6
    //   121: astore 4
    //   123: aload 7
    //   125: astore 5
    //   127: invokestatic 84	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   130: astore 9
    //   132: aload 6
    //   134: astore 4
    //   136: aload 7
    //   138: astore 5
    //   140: aload 9
    //   142: aload_0
    //   143: getfield 105	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoUrls	[B
    //   146: iconst_0
    //   147: aload_0
    //   148: getfield 105	com/tencent/mobileqq/data/QZonePhotoWall:vPhotoUrls	[B
    //   151: arraylength
    //   152: invokevirtual 146	android/os/Parcel:unmarshall	([BII)V
    //   155: aload 6
    //   157: astore 4
    //   159: aload 7
    //   161: astore 5
    //   163: aload 9
    //   165: iconst_0
    //   166: invokevirtual 88	android/os/Parcel:setDataPosition	(I)V
    //   169: aload 6
    //   171: astore 4
    //   173: aload 7
    //   175: astore 5
    //   177: aload 9
    //   179: aload_0
    //   180: invokevirtual 152	java/lang/Object:getClass	()Ljava/lang/Class;
    //   183: invokevirtual 158	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   186: invokevirtual 162	android/os/Parcel:readArrayList	(Ljava/lang/ClassLoader;)Ljava/util/ArrayList;
    //   189: astore 6
    //   191: aload 6
    //   193: astore 4
    //   195: aload 6
    //   197: astore 5
    //   199: aload 9
    //   201: invokevirtual 101	android/os/Parcel:recycle	()V
    //   204: aload 6
    //   206: astore 4
    //   208: aload_2
    //   209: ifnull +264 -> 473
    //   212: aload_3
    //   213: ifnull +260 -> 473
    //   216: aload 4
    //   218: ifnull +255 -> 473
    //   221: iconst_0
    //   222: istore_1
    //   223: iload_1
    //   224: aload_2
    //   225: invokevirtual 109	java/util/ArrayList:size	()I
    //   228: if_icmpge +245 -> 473
    //   231: new 57	NS_MOBILE_MAIN_PAGE/PhotoWall
    //   234: dup
    //   235: invokespecial 163	NS_MOBILE_MAIN_PAGE/PhotoWall:<init>	()V
    //   238: astore 5
    //   240: aload 5
    //   242: aload_3
    //   243: iload_1
    //   244: invokevirtual 167	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   247: checkcast 70	java/lang/Long
    //   250: invokevirtual 171	java/lang/Long:longValue	()J
    //   253: putfield 68	NS_MOBILE_MAIN_PAGE/PhotoWall:ctime	J
    //   256: aload 5
    //   258: aload_2
    //   259: iload_1
    //   260: invokevirtual 167	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   263: checkcast 173	java/lang/String
    //   266: putfield 60	NS_MOBILE_MAIN_PAGE/PhotoWall:photoId	Ljava/lang/String;
    //   269: aload 5
    //   271: aload 4
    //   273: iload_1
    //   274: invokevirtual 167	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   277: checkcast 175	java/util/Map
    //   280: putfield 78	NS_MOBILE_MAIN_PAGE/PhotoWall:photoUrls	Ljava/util/Map;
    //   283: aload 8
    //   285: aload 5
    //   287: invokevirtual 64	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   290: pop
    //   291: iload_1
    //   292: iconst_1
    //   293: iadd
    //   294: istore_1
    //   295: goto -72 -> 223
    //   298: astore_3
    //   299: aconst_null
    //   300: astore_2
    //   301: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +13 -> 317
    //   307: ldc 182
    //   309: iconst_2
    //   310: aload_3
    //   311: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   314: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: goto -256 -> 61
    //   320: astore_3
    //   321: aconst_null
    //   322: astore_2
    //   323: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +13 -> 339
    //   329: ldc 182
    //   331: iconst_2
    //   332: aload_3
    //   333: invokevirtual 188	java/lang/Error:toString	()Ljava/lang/String;
    //   336: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: goto -278 -> 61
    //   342: astore 4
    //   344: aconst_null
    //   345: astore_3
    //   346: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +14 -> 363
    //   352: ldc 182
    //   354: iconst_2
    //   355: aload 4
    //   357: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   360: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: goto -251 -> 112
    //   366: astore 4
    //   368: aconst_null
    //   369: astore_3
    //   370: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +14 -> 387
    //   376: ldc 182
    //   378: iconst_2
    //   379: aload 4
    //   381: invokevirtual 188	java/lang/Error:toString	()Ljava/lang/String;
    //   384: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: goto -275 -> 112
    //   390: astore 5
    //   392: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   395: ifeq +14 -> 409
    //   398: ldc 182
    //   400: iconst_2
    //   401: aload 5
    //   403: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   406: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: goto -201 -> 208
    //   412: astore 4
    //   414: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +14 -> 431
    //   420: ldc 182
    //   422: iconst_2
    //   423: aload 4
    //   425: invokevirtual 188	java/lang/Error:toString	()Ljava/lang/String;
    //   428: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload 5
    //   433: astore 4
    //   435: goto -227 -> 208
    //   438: astore_2
    //   439: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +31 -> 473
    //   445: ldc 190
    //   447: iconst_2
    //   448: new 117	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   455: ldc 193
    //   457: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_2
    //   461: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   464: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: aload 8
    //   475: areturn
    //   476: astore 4
    //   478: goto -108 -> 370
    //   481: astore 4
    //   483: goto -137 -> 346
    //   486: astore_3
    //   487: goto -164 -> 323
    //   490: astore_3
    //   491: goto -190 -> 301
    //   494: aconst_null
    //   495: astore 4
    //   497: goto -289 -> 208
    //   500: aconst_null
    //   501: astore_3
    //   502: goto -390 -> 112
    //   505: aconst_null
    //   506: astore_2
    //   507: goto -446 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	this	QZonePhotoWall
    //   222	73	1	i	int
    //   56	267	2	localArrayList1	ArrayList
    //   438	23	2	localException1	java.lang.Exception
    //   506	1	2	localObject1	Object
    //   25	218	3	localObject2	Object
    //   298	13	3	localException2	java.lang.Exception
    //   320	13	3	localError1	java.lang.Error
    //   345	25	3	localObject3	Object
    //   486	1	3	localError2	java.lang.Error
    //   490	1	3	localException3	java.lang.Exception
    //   501	1	3	localObject4	Object
    //   71	201	4	localObject5	Object
    //   342	14	4	localException4	java.lang.Exception
    //   366	14	4	localError3	java.lang.Error
    //   412	12	4	localError4	java.lang.Error
    //   433	1	4	localObject6	Object
    //   476	1	4	localError5	java.lang.Error
    //   481	1	4	localException5	java.lang.Exception
    //   495	1	4	localObject7	Object
    //   125	161	5	localObject8	Object
    //   390	42	5	localException6	java.lang.Exception
    //   4	201	6	localArrayList2	ArrayList
    //   1	173	7	localObject9	Object
    //   13	461	8	localArrayList3	ArrayList
    //   130	70	9	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   22	57	298	java/lang/Exception
    //   22	57	320	java/lang/Error
    //   68	107	342	java/lang/Exception
    //   68	107	366	java/lang/Error
    //   127	132	390	java/lang/Exception
    //   140	155	390	java/lang/Exception
    //   163	169	390	java/lang/Exception
    //   177	191	390	java/lang/Exception
    //   199	204	390	java/lang/Exception
    //   127	132	412	java/lang/Error
    //   140	155	412	java/lang/Error
    //   163	169	412	java/lang/Error
    //   177	191	412	java/lang/Error
    //   199	204	412	java/lang/Error
    //   223	291	438	java/lang/Exception
    //   107	112	476	java/lang/Error
    //   107	112	481	java/lang/Exception
    //   57	61	486	java/lang/Error
    //   57	61	490	java/lang/Exception
  }
  
  public void updateQzonePhotoWall(String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    if (parammobile_sub_get_photo_wall_rsp == null) {}
    do
    {
      return;
      this.totalPic = parammobile_sub_get_photo_wall_rsp.total_pic;
      this.hasMore = parammobile_sub_get_photo_wall_rsp.iHasMore;
      packPhotoWallData(paramString, parammobile_sub_get_photo_wall_rsp.vecUrls);
      this.attachInfo = parammobile_sub_get_photo_wall_rsp.attachInfo;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qzonephotowall", 2, "updateQzonePhotoWall " + toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QZonePhotoWall
 * JD-Core Version:    0.7.0.1
 */