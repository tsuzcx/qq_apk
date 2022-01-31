package com.tencent.mobileqq.nearby.now.location;

import aefg;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.LbsShare.LocationReq;
import com.tencent.pb.now.LbsShare.LocationResp;
import com.tencent.pb.now.LbsShare.POI;
import com.tencent.util.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LocationDataManager
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LocationDataManager.UiUpdate jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager$UiUpdate;
  private LocationInfo jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
  private NowShortVideoProtoManager jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolNowShortVideoProtoManager;
  private String jdField_a_of_type_JavaLangString;
  private final List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private LocationInfo jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
  private List jdField_b_of_type_JavaUtilList;
  
  public LocationDataManager(LocationInfo paramLocationInfo, LocationDataManager.UiUpdate paramUiUpdate, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = paramLocationInfo;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager$UiUpdate = paramUiUpdate;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolNowShortVideoProtoManager = new NowShortVideoProtoManager(paramQQAppInterface);
  }
  
  private void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, "", false);
  }
  
  /* Error */
  private void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/tencent/mobileqq/nearby/now/location/LocationDataManager:jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo	Lcom/tencent/mobileqq/nearby/now/model/LocationInfo;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 53	com/tencent/pb/now/LbsShare$LocationReq
    //   11: dup
    //   12: invokespecial 54	com/tencent/pb/now/LbsShare$LocationReq:<init>	()V
    //   15: astore 10
    //   17: aload_0
    //   18: getfield 51	com/tencent/mobileqq/nearby/now/location/LocationDataManager:jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo	Lcom/tencent/mobileqq/nearby/now/model/LocationInfo;
    //   21: invokevirtual 60	com/tencent/mobileqq/nearby/now/model/LocationInfo:getLat	()Ljava/lang/String;
    //   24: invokestatic 66	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   27: invokevirtual 70	java/lang/Double:doubleValue	()D
    //   30: dstore 5
    //   32: dload 5
    //   34: ldc2_w 71
    //   37: dmul
    //   38: dstore 5
    //   40: aload_0
    //   41: getfield 51	com/tencent/mobileqq/nearby/now/location/LocationDataManager:jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo	Lcom/tencent/mobileqq/nearby/now/model/LocationInfo;
    //   44: invokevirtual 75	com/tencent/mobileqq/nearby/now/model/LocationInfo:getLng	()Ljava/lang/String;
    //   47: invokestatic 66	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   50: invokevirtual 70	java/lang/Double:doubleValue	()D
    //   53: dstore 7
    //   55: dload 7
    //   57: ldc2_w 71
    //   60: dmul
    //   61: dstore 7
    //   63: dload 5
    //   65: ldc2_w 76
    //   68: dcmpl
    //   69: ifeq +12 -> 81
    //   72: dload 7
    //   74: ldc2_w 76
    //   77: dcmpl
    //   78: ifne +78 -> 156
    //   81: ldc 79
    //   83: ldc 81
    //   85: invokestatic 87	com/tencent/util/LogUtil:d	(Ljava/lang/Object;Ljava/lang/String;)I
    //   88: pop
    //   89: return
    //   90: astore 9
    //   92: ldc2_w 76
    //   95: dstore 5
    //   97: aload 9
    //   99: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   102: ldc 79
    //   104: new 92	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   111: ldc 95
    //   113: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 51	com/tencent/mobileqq/nearby/now/location/LocationDataManager:jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo	Lcom/tencent/mobileqq/nearby/now/model/LocationInfo;
    //   120: invokevirtual 60	com/tencent/mobileqq/nearby/now/model/LocationInfo:getLat	()Ljava/lang/String;
    //   123: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 101
    //   128: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 51	com/tencent/mobileqq/nearby/now/location/LocationDataManager:jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo	Lcom/tencent/mobileqq/nearby/now/model/LocationInfo;
    //   135: invokevirtual 75	com/tencent/mobileqq/nearby/now/model/LocationInfo:getLng	()Ljava/lang/String;
    //   138: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 107	com/tencent/util/LogUtil:e	(Ljava/lang/Object;Ljava/lang/String;)I
    //   147: pop
    //   148: ldc2_w 76
    //   151: dstore 7
    //   153: goto -90 -> 63
    //   156: aload 10
    //   158: getfield 111	com/tencent/pb/now/LbsShare$LocationReq:lat	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   161: dload 5
    //   163: d2i
    //   164: invokevirtual 117	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   167: aload 10
    //   169: getfield 120	com/tencent/pb/now/LbsShare$LocationReq:lng	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   172: dload 7
    //   174: d2i
    //   175: invokevirtual 117	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   178: aload 10
    //   180: getfield 124	com/tencent/pb/now/LbsShare$LocationReq:coordinate	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   183: iconst_1
    //   184: invokevirtual 127	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   187: aload_2
    //   188: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +12 -> 203
    //   194: aload 10
    //   196: getfield 137	com/tencent/pb/now/LbsShare$LocationReq:keyword	Lcom/tencent/mobileqq/pb/PBStringField;
    //   199: aload_2
    //   200: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   203: aload_3
    //   204: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +12 -> 219
    //   210: aload 10
    //   212: getfield 145	com/tencent/pb/now/LbsShare$LocationReq:category	Lcom/tencent/mobileqq/pb/PBStringField;
    //   215: aload_3
    //   216: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   219: aload 10
    //   221: getfield 148	com/tencent/pb/now/LbsShare$LocationReq:page	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   224: iload_1
    //   225: invokevirtual 127	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   228: aload 10
    //   230: getfield 151	com/tencent/pb/now/LbsShare$LocationReq:count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   233: bipush 25
    //   235: invokevirtual 127	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   238: iload 4
    //   240: ifeq +12 -> 252
    //   243: aload 10
    //   245: getfield 154	com/tencent/pb/now/LbsShare$LocationReq:requireMyLbs	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   248: iconst_1
    //   249: invokevirtual 127	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   252: aload 10
    //   254: getfield 157	com/tencent/pb/now/LbsShare$LocationReq:city	Lcom/tencent/mobileqq/pb/PBStringField;
    //   257: aload_0
    //   258: getfield 51	com/tencent/mobileqq/nearby/now/location/LocationDataManager:jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo	Lcom/tencent/mobileqq/nearby/now/model/LocationInfo;
    //   261: invokevirtual 160	com/tencent/mobileqq/nearby/now/model/LocationInfo:getCity	()Ljava/lang/String;
    //   264: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   267: aload_0
    //   268: aload 10
    //   270: aload_2
    //   271: invokespecial 163	com/tencent/mobileqq/nearby/now/location/LocationDataManager:a	(Lcom/tencent/pb/now/LbsShare$LocationReq;Ljava/lang/String;)V
    //   274: return
    //   275: astore 9
    //   277: goto -180 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	LocationDataManager
    //   0	280	1	paramInt	int
    //   0	280	2	paramString1	String
    //   0	280	3	paramString2	String
    //   0	280	4	paramBoolean	boolean
    //   30	132	5	d1	double
    //   53	120	7	d2	double
    //   90	8	9	localException1	java.lang.Exception
    //   275	1	9	localException2	java.lang.Exception
    //   15	254	10	localLocationReq	LbsShare.LocationReq
    // Exception table:
    //   from	to	target	type
    //   17	32	90	java/lang/Exception
    //   40	55	275	java/lang/Exception
  }
  
  private void a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      return;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.add(new LocationInfo());
    if ((paramLocationInfo1 != null) && (!paramLocationInfo1.isCityEmpty())) {
      this.jdField_b_of_type_JavaUtilList.add(paramLocationInfo1);
    }
    if ((paramLocationInfo2 != null) && (!paramLocationInfo2.isNameEmpty())) {
      this.jdField_b_of_type_JavaUtilList.add(paramLocationInfo2);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((LocationInfo)this.jdField_a_of_type_JavaUtilList.get(i)).equals(paramLocationInfo2)) {
        LogUtil.d("LocationDataManager", "createNewHeaderNearByList: remove the same one");
      }
    }
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
      this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private void a(LbsShare.LocationReq paramLocationReq, String paramString)
  {
    LogUtil.d("LocationDataManager", "sendCsTask: hasNextPage:" + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolNowShortVideoProtoManager.a(paramLocationReq, new aefg(this, paramString));
  }
  
  private void a(LbsShare.LocationResp paramLocationResp, String paramString)
  {
    Object localObject = paramLocationResp.poilist.get();
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true; (localObject == null) || (((List)localObject).size() < 1); bool = false)
    {
      this.jdField_b_of_type_Int += 1;
      LogUtil.d("LocationDataManager", "getResult: poiList is empty !!!");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager$UiUpdate != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager$UiUpdate.a(null, bool, false);
      }
      return;
    }
    if (paramLocationResp.is_foreign.get() != 0) {}
    for (int i = 1;; i = 0)
    {
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (LbsShare.POI)paramString.next();
        LocationInfo localLocationInfo = new LocationInfo();
        if (!TextUtils.isEmpty(((LbsShare.POI)localObject).city.get())) {
          localLocationInfo.setCity(((LbsShare.POI)localObject).city.get());
        }
        if (!TextUtils.isEmpty(((LbsShare.POI)localObject).name.get())) {
          localLocationInfo.setName(((LbsShare.POI)localObject).name.get());
        }
        if (!TextUtils.isEmpty(((LbsShare.POI)localObject).addr.get())) {
          localLocationInfo.setAddress(((LbsShare.POI)localObject).addr.get());
        }
        localLocationInfo.setLat(String.valueOf(((LbsShare.POI)localObject).lat.get() / 1000000.0D));
        localLocationInfo.setLng(String.valueOf(((LbsShare.POI)localObject).lng.get() / 1000000.0D));
        if (i != 0) {
          localLocationInfo.setForeign(true);
        }
        LogUtil.v("LocationDataManager", "getResult: " + localLocationInfo.toString());
        if (!this.jdField_a_of_type_JavaUtilList.contains(localLocationInfo)) {
          this.jdField_a_of_type_JavaUtilList.add(localLocationInfo);
        }
      }
      if (paramLocationResp.next.get() != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      for (;;)
      {
        LogUtil.d("LocationDataManager", "getResult: hasNextPage:" + this.jdField_a_of_type_Boolean);
        if ((!TextUtils.isEmpty(paramLocationResp.search_id.get())) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager$UiUpdate == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager$UiUpdate.a(this.jdField_a_of_type_JavaUtilList, bool, this.jdField_a_of_type_Boolean);
        return;
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2)
  {
    a(paramLocationInfo1, paramLocationInfo2);
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(LocationInfo paramLocationInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = paramLocationInfo;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = true;
    a("");
  }
  
  public void a(String paramString)
  {
    LogUtil.d("LocationDataManager", "search: keyword :" + paramString);
    if (paramString == null)
    {
      LogUtil.e("LocationDataManager", "search: keyword can't be null!!!");
      return;
    }
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Boolean = true;
    }
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString)
  {
    LbsShare.LocationResp localLocationResp = new LbsShare.LocationResp();
    try
    {
      localLocationResp.mergeFrom(paramArrayOfByte);
      if (localLocationResp.ec.get() != 0)
      {
        LogUtil.e("LocationDataManager", "error code:" + localLocationResp.ec.get());
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager$UiUpdate != null)
        {
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationLocationDataManager$UiUpdate;
          if (TextUtils.isEmpty(paramString)) {
            break label89;
          }
        }
        label89:
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.a(bool);
          return;
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      LogUtil.i("LocationDataManager", "error found in merge GetApplyForMicDetailRsp data");
      paramArrayOfByte.printStackTrace();
      a(localLocationResp, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.location.LocationDataManager
 * JD-Core Version:    0.7.0.1
 */