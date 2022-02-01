package com.tencent.mobileqq.kandian.biz.publisher.column;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.ReqBody;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.RspBody;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListReq;
import tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListRsp;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.ReqBody;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.TopicInfoSetReq;
import tencent.kandian.ugc.topic_info.TopicInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/column/ColumnModeImpl;", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "createColumn", "", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "callback", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnCallback;", "editColumn", "getColumnList", "cookie", "", "topTopicId", "", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnListCallback;", "getCommonReportDataBuilder", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "handleGetTopicListSuccessResult", "data", "sendGetColumnListRequest", "sendManageColumnRequest", "actionType", "", "parseToTopicInfo", "Ltencent/kandian/ugc/topic_info$TopicInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ColumnModeImpl
  implements IColumnModel
{
  public static final ColumnModeImpl.Companion a;
  @NotNull
  private final QQAppInterface a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPublisherColumnColumnModeImpl$Companion = new ColumnModeImpl.Companion(null);
  }
  
  public ColumnModeImpl(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private final RIJTransMergeKanDianReport.ReportR5Builder a(TopicInfo paramTopicInfo)
  {
    int n = 1;
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    boolean bool1 = RIJUgcUtils.p();
    boolean bool2 = RIJUgcUtils.h();
    int k;
    int j;
    label53:
    label68:
    int m;
    label76:
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder2;
    if (!TextUtils.isEmpty((CharSequence)paramTopicInfo.getCoverUrl()))
    {
      k = 1;
      if (TextUtils.isEmpty((CharSequence)paramTopicInfo.getTitle())) {
        break label203;
      }
      j = 1;
      if (TextUtils.isEmpty((CharSequence)paramTopicInfo.getIntro())) {
        break label208;
      }
      i = 1;
      if (!bool1) {
        break label213;
      }
      m = 1;
      localReportR5Builder2 = localReportR5Builder1.a("ugc_video_flag", Integer.valueOf(m));
      if (!bool2) {
        break label219;
      }
      m = 1;
      label98:
      localReportR5Builder2 = localReportR5Builder2.a("ugc_column_flag", Integer.valueOf(m));
      if (k == 0) {
        break label225;
      }
      k = 1;
      label120:
      localReportR5Builder2 = localReportR5Builder2.a("cover_flag", Integer.valueOf(k));
      if (j == 0) {
        break label231;
      }
      j = 1;
      label140:
      localReportR5Builder2 = localReportR5Builder2.a("column_name_flag", Integer.valueOf(j));
      if (i == 0) {
        break label236;
      }
      i = 1;
      label159:
      localReportR5Builder2 = localReportR5Builder2.a("introduction_flag", Integer.valueOf(i));
      if (!paramTopicInfo.getAllowSubmit()) {
        break label241;
      }
    }
    label203:
    label208:
    label213:
    label219:
    label225:
    label231:
    label236:
    label241:
    for (int i = n;; i = 0)
    {
      localReportR5Builder2.a("collaborator_flag", Integer.valueOf(i));
      return localReportR5Builder1;
      k = 0;
      break;
      j = 0;
      break label53;
      i = 0;
      break label68;
      m = 0;
      break label76;
      m = 0;
      break label98;
      k = 0;
      break label120;
      j = 0;
      break label140;
      i = 0;
      break label159;
    }
  }
  
  private final TopicInfo a(@NotNull topic_info.TopicInfo paramTopicInfo)
  {
    boolean bool = false;
    TopicInfo localTopicInfo = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
    localTopicInfo.setTopicId(paramTopicInfo.id.get());
    String str = paramTopicInfo.cover_img.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "cover_img.get()");
    localTopicInfo.setCoverUrl(str);
    str = paramTopicInfo.title.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "title.get()");
    localTopicInfo.setTitle(str);
    str = paramTopicInfo.intro.get();
    Intrinsics.checkExpressionValueIsNotNull(str, "intro.get()");
    localTopicInfo.setIntro(str);
    if (paramTopicInfo.submit_permission.get() == 1) {
      bool = true;
    }
    localTopicInfo.setAllowSubmit(bool);
    localTopicInfo.setSource(paramTopicInfo.source.get());
    localTopicInfo.setUid(paramTopicInfo.creator_uid.get());
    return localTopicInfo;
  }
  
  private final topic_info.TopicInfo a(@NotNull TopicInfo paramTopicInfo)
  {
    topic_info.TopicInfo localTopicInfo = new topic_info.TopicInfo();
    localTopicInfo.id.set((int)paramTopicInfo.getTopicId());
    localTopicInfo.cover_img.set(paramTopicInfo.getCoverUrl());
    localTopicInfo.title.set(paramTopicInfo.getTitle());
    localTopicInfo.intro.set(paramTopicInfo.getIntro());
    PBUInt32Field localPBUInt32Field = localTopicInfo.submit_permission;
    if (paramTopicInfo.getAllowSubmit()) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localTopicInfo.source.set(paramTopicInfo.getSource());
      localTopicInfo.creator_uid.set(paramTopicInfo.getUid());
      return localTopicInfo;
    }
  }
  
  private final void a(TopicInfo paramTopicInfo, IColumnModel.IColumnCallback paramIColumnCallback, int paramInt)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC5B", a(paramTopicInfo).a());
    oidb_0xe33.TopicInfoSetReq localTopicInfoSetReq = new oidb_0xe33.TopicInfoSetReq();
    if (paramInt == 1) {
      localTopicInfoSetReq.operate_type.set(1);
    }
    for (;;)
    {
      localTopicInfoSetReq.info.set((MessageMicro)a(paramTopicInfo));
      paramTopicInfo = new oidb_0xe33.ReqBody();
      paramTopicInfo.topic_info_set_req.set((MessageMicro)localTopicInfoSetReq);
      ProtoUtils.a((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ProtoUtils.TroopProtocolObserver)new ColumnModeImpl.sendManageColumnRequest.1(paramIColumnCallback, paramInt), paramTopicInfo.toByteArray(), "OidbSvc.0xe33", 3635, 1);
      return;
      if (paramInt == 2) {
        localTopicInfoSetReq.operate_type.set(2);
      }
    }
  }
  
  private final void a(byte[] paramArrayOfByte, IColumnModel.IColumnListCallback paramIColumnListCallback)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    try
    {
      localObject1 = new oidb_0xe31.RspBody();
      ((oidb_0xe31.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      if ((!((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp.has()) || (((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp.topics.size() == 0))
      {
        QLog.e("ColumnModuleImpl", 1, "handleGetTopicListSuccessResult no topicInfo data!");
        return;
      }
      paramArrayOfByte = ((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp;
      localObject1 = paramArrayOfByte.topics.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "topics");
      int j = ((Collection)localObject1).size();
      while (i < j)
      {
        localObject2 = ((List)localObject1).get(i);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "topics[i]");
        localArrayList.add(a((topic_info.TopicInfo)localObject2));
        i += 1;
      }
      QLog.i("ColumnModuleImpl", 2, "loadDataFromNetwork success, topicList.num = " + localArrayList.size());
      if (paramIColumnListCallback != null)
      {
        localObject1 = paramArrayOfByte.cookie.get().toStringUtf8();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "rsp.cookie.get().toStringUtf8()");
        localObject2 = Charsets.UTF_8;
        if (localObject1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject1;
      Object localObject2;
      if (QLog.isColorLevel()) {
        QLog.d("ColumnModuleImpl", 2, "loadColumnListFromNetwork failed.");
      }
      if (paramIColumnListCallback != null)
      {
        paramIColumnListCallback.a(-1, "", null, true, null);
        return;
        localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
        paramIColumnListCallback.a(0, "", (byte[])localObject1, paramArrayOfByte.is_end.get(), (List)localArrayList);
      }
    }
  }
  
  private final void b(byte[] paramArrayOfByte, long paramLong, IColumnModel.IColumnListCallback paramIColumnListCallback)
  {
    oidb_0xe31.TopicListReq localTopicListReq = new oidb_0xe31.TopicListReq();
    PBUInt64Field localPBUInt64Field = localTopicListReq.uid;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Intrinsics.checkExpressionValueIsNotNull(str, "app.currentAccountUin");
    localPBUInt64Field.set(Long.parseLong(str));
    if (paramArrayOfByte != null) {
      localTopicListReq.cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localTopicListReq.num.set(10);
    if (paramLong != 0L) {
      localTopicListReq.top_topic_id.set((int)paramLong);
    }
    paramArrayOfByte = new oidb_0xe31.ReqBody();
    paramArrayOfByte.topic_list_req_req.set((MessageMicro)localTopicListReq);
    ProtoUtils.a((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ProtoUtils.TroopProtocolObserver)new ColumnModeImpl.sendGetColumnListRequest.1(this, paramIColumnListCallback), paramArrayOfByte.toByteArray(), "OidbSvc.0xe31", 3633, 3);
  }
  
  public void a(@NotNull TopicInfo paramTopicInfo, @Nullable IColumnModel.IColumnCallback paramIColumnCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    if (QLog.isColorLevel()) {
      QLog.e("ColumnModuleImpl", 2, "ManageColumnModel createColumn: columnInfo : " + paramTopicInfo);
    }
    a(paramTopicInfo, paramIColumnCallback, 1);
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, long paramLong, @Nullable IColumnModel.IColumnListCallback paramIColumnListCallback)
  {
    b(paramArrayOfByte, paramLong, paramIColumnListCallback);
  }
  
  public void b(@NotNull TopicInfo paramTopicInfo, @Nullable IColumnModel.IColumnCallback paramIColumnCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    if (QLog.isColorLevel()) {
      QLog.e("ColumnModuleImpl", 2, "ManageColumnModel editColumn: columnInfo : " + paramTopicInfo);
    }
    a(paramTopicInfo, paramIColumnCallback, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.column.ColumnModeImpl
 * JD-Core Version:    0.7.0.1
 */