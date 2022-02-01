package com.tencent.mobileqq.kandian.biz.ugc.mycolumn;

import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.mvp.ListModel;
import com.tencent.mobileqq.kandian.base.mvp.ListModel.LoadDataFromDBCallback;
import com.tencent.mobileqq.kandian.base.mvp.ListModel.LoadDataFromNetworkCallback;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.ReqBody;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.RspBody;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListReq;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListRsp;
import tencent.kandian.ugc.topic_info.TopicInfo;

public class MyColumnModel
  extends ListModel<ColumnInfo, ByteString>
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  
  private void a(ListModel.LoadDataFromNetworkCallback<ColumnInfo, ByteString> paramLoadDataFromNetworkCallback, byte[] paramArrayOfByte, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localObject = new oidb_0xe31.RspBody();
      ((oidb_0xe31.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if ((!((oidb_0xe31.RspBody)localObject).topic_list_req_rsp.has()) || (((oidb_0xe31.RspBody)localObject).topic_list_req_rsp.topics.size() == 0)) {
        break label214;
      }
      paramArrayOfByte = ((oidb_0xe31.RspBody)localObject).topic_list_req_rsp;
      localObject = paramArrayOfByte.topics.get();
      i = 0;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        Object localObject;
        int i;
        ColumnInfo localColumnInfo;
        label214:
        continue;
        i += 1;
      }
    }
    if (i < ((List)localObject).size())
    {
      localColumnInfo = new ColumnInfo((topic_info.TopicInfo)((List)localObject).get(i));
      if (a(localColumnInfo)) {
        localArrayList.add(localColumnInfo);
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadDataFromNetwork success, topicList.num = ");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.i("RIJUGC.MyColumnModel", 2, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_Int = paramArrayOfByte.total.get();
      paramLoadDataFromNetworkCallback.a(true, paramArrayOfByte.is_end.get(), paramArrayOfByte.total.get(), localArrayList, ByteString.encodeUtf8(paramArrayOfByte.cookie.get().toStringUtf8()), paramInt, "");
      return;
      QLog.e("RIJUGC.MyColumnModel", 1, "handleSuccessResult no column data!");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
      }
      paramLoadDataFromNetworkCallback.a(false, true, 0, new ArrayList(), null, paramInt, "");
      return;
    }
  }
  
  private boolean a(ColumnInfo paramColumnInfo)
  {
    return paramColumnInfo.coverUrl.isEmpty() ^ true;
  }
  
  public void a(ListModel.LoadDataFromDBCallback<ColumnInfo> paramLoadDataFromDBCallback) {}
  
  public void a(List<ColumnInfo> paramList) {}
  
  public void a(ByteString paramByteString, ListModel.LoadDataFromNetworkCallback<ColumnInfo, ByteString> paramLoadDataFromNetworkCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadDataFromNetwork start request cookie = ");
    ((StringBuilder)localObject).append(paramByteString);
    QLog.i("RIJUGC.MyColumnModel", 2, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Boolean)
    {
      paramLoadDataFromNetworkCallback = new StringBuilder();
      paramLoadDataFromNetworkCallback.append("loadDataFromNetwork return since mIsRequesting is true start = ");
      paramLoadDataFromNetworkCallback.append(paramByteString);
      QLog.i("RIJUGC.MyColumnModel", 2, paramLoadDataFromNetworkCallback.toString());
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    localObject = new oidb_0xe31.TopicListReq();
    ((oidb_0xe31.TopicListReq)localObject).uid.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    if (paramByteString != null) {
      ((oidb_0xe31.TopicListReq)localObject).cookie.set(ByteStringMicro.copyFrom(paramByteString.toByteArray()));
    }
    ((oidb_0xe31.TopicListReq)localObject).num.set(10);
    if (this.b != 0) {
      ((oidb_0xe31.TopicListReq)localObject).top_topic_id.set(this.b);
    }
    paramByteString = new oidb_0xe31.ReqBody();
    paramByteString.topic_list_req_req.set((MessageMicro)localObject);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new MyColumnModel.1(this, paramLoadDataFromNetworkCallback), paramByteString.toByteArray(), "OidbSvc.0xe31", 3633, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.mycolumn.MyColumnModel
 * JD-Core Version:    0.7.0.1
 */