import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.biz.qqstory.network.request.CommonRequest;
import com.tencent.biz.qqstory.network.response.CommonResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import mqq.util.WeakReference;

public class ncn
  extends CmdTaskManger.UIThreadCallback
{
  public ncn(LbsManager paramLbsManager, WeakReference paramWeakReference, LbsManager.POIListRequestSession paramPOIListRequestSession) {}
  
  public void a(@NonNull CommonRequest paramCommonRequest, @Nullable CommonResponse paramCommonResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramCommonResponse == null)
    {
      SLog.d("LbsManager", "response is null");
      paramCommonRequest = (LbsManager.POIListRequestCallback)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramCommonRequest != null) {
        paramCommonRequest.a(paramErrorMessage.errorCode, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, Collections.EMPTY_LIST);
      }
      return;
    }
    paramCommonRequest = new qqstory_service.RspGetPOIList();
    paramCommonResponse = paramCommonResponse.a;
    try
    {
      paramCommonRequest.mergeFrom(paramCommonResponse);
      paramCommonResponse = new ArrayList();
      if (paramCommonRequest.result.error_code.get() == 0)
      {
        paramErrorMessage = paramCommonRequest.poi_list.get();
        SLog.b("LbsManager", "poiListSize = " + paramCommonRequest.poi_list.size());
        SLog.b("LbsManager", "poiList isend = " + paramCommonRequest.is_end.get());
        if (paramErrorMessage.size() > 0) {
          if (paramCommonRequest.is_end.get() > 0)
          {
            i = 1;
            localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession;
            if (i != 0) {
              break label417;
            }
            bool = true;
            ((LbsManager.POIListRequestSession)localObject).jdField_a_of_type_Boolean = bool;
            localObject = paramCommonRequest.next_cookie.get().toStringUtf8();
            if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.jdField_a_of_type_JavaUtilHashSet.contains(localObject)) {
              break label457;
            }
            i = 0;
            for (;;)
            {
              if (i >= paramErrorMessage.size()) {
                break label435;
              }
              qqstory_struct.Address localAddress = (qqstory_struct.Address)paramErrorMessage.get(i);
              String str1 = localAddress.city.get().toStringUtf8();
              String str2 = localAddress.building.get().toStringUtf8();
              if (!localAddress.gps.has()) {
                break;
              }
              j = localAddress.gps.lng.get();
              String str3 = localAddress.street.get().toStringUtf8();
              if (!localAddress.gps.has()) {
                break label429;
              }
              k = localAddress.gps.lat.get();
              paramCommonResponse.add(new TroopBarPOI("", str1, str2, j, str3, k, localAddress.province.get().toString()));
              i += 1;
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramCommonResponse)
    {
      Object localObject;
      for (;;)
      {
        SLog.e("LbsManager", "InvalidProtocolBufferMicroException: " + paramCommonResponse.getMessage());
        continue;
        int i = 0;
        continue;
        label417:
        boolean bool = false;
        continue;
        int j = 0;
        continue;
        label429:
        int k = 0;
      }
      label435:
      this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.jdField_a_of_type_JavaUtilHashSet.add(localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.jdField_a_of_type_JavaLangString = ((String)localObject);
      label457:
      paramErrorMessage = (LbsManager.POIListRequestCallback)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramErrorMessage != null)
      {
        paramErrorMessage.a(paramCommonRequest.result.error_code.get(), this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, paramCommonResponse);
        return;
      }
      SLog.d("LbsManager", "POIListRequestCallback has been recycled.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncn
 * JD-Core Version:    0.7.0.1
 */