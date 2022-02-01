package com.tencent.mobileqq.kandian.biz.publisher.column;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/column/ColumnModeImpl;", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "createColumn", "", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "callback", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnCallback;", "editColumn", "getColumnList", "cookie", "", "topTopicId", "", "Lcom/tencent/mobileqq/kandian/biz/publisher/column/IColumnModel$IColumnListCallback;", "getCommonReportDataBuilder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "handleGetTopicListSuccessResult", "data", "sendGetColumnListRequest", "sendManageColumnRequest", "actionType", "", "parseToTopicInfo", "Ltencent/kandian/ugc/topic_info$TopicInfo;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final TopicInfo a(@NotNull topic_info.TopicInfo paramTopicInfo)
  {
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
    int i = paramTopicInfo.submit_permission.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localTopicInfo.setAllowSubmit(bool);
    localTopicInfo.setSource(paramTopicInfo.source.get());
    localTopicInfo.setUid(paramTopicInfo.creator_uid.get());
    return localTopicInfo;
  }
  
  private final topic_info.TopicInfo a(@NotNull TopicInfo paramTopicInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final void a(TopicInfo paramTopicInfo, IColumnModel.IColumnCallback paramIColumnCallback, int paramInt)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC5B", a(paramTopicInfo).build());
    oidb_0xe33.TopicInfoSetReq localTopicInfoSetReq = new oidb_0xe33.TopicInfoSetReq();
    if (paramInt == 1) {
      localTopicInfoSetReq.operate_type.set(1);
    } else if (paramInt == 2) {
      localTopicInfoSetReq.operate_type.set(2);
    }
    localTopicInfoSetReq.info.set((MessageMicro)a(paramTopicInfo));
    paramTopicInfo = new oidb_0xe33.ReqBody();
    paramTopicInfo.topic_info_set_req.set((MessageMicro)localTopicInfoSetReq);
    ProtoUtils.a((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ProtoUtils.TroopProtocolObserver)new ColumnModeImpl.sendManageColumnRequest.1(paramIColumnCallback, paramInt), paramTopicInfo.toByteArray(), "OidbSvc.0xe33", 3635, 1);
  }
  
  private final void a(byte[] paramArrayOfByte, IColumnModel.IColumnListCallback paramIColumnListCallback)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = new oidb_0xe31.RspBody();
      ((oidb_0xe31.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      if ((((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp.has()) && (((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp.topics.size() != 0))
      {
        paramArrayOfByte = ((oidb_0xe31.RspBody)localObject1).topic_list_req_rsp;
        localObject1 = paramArrayOfByte.topics.get();
        int i = 0;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "topics");
        int j = ((Collection)localObject1).size();
        while (i < j)
        {
          localObject2 = ((List)localObject1).get(i);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "topics[i]");
          localArrayList.add(a((topic_info.TopicInfo)localObject2));
          i += 1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadDataFromNetwork success, topicList.num = ");
        ((StringBuilder)localObject1).append(localArrayList.size());
        QLog.i("ColumnModuleImpl", 2, ((StringBuilder)localObject1).toString());
        if (paramIColumnListCallback == null) {
          break label308;
        }
        localObject1 = paramArrayOfByte.cookie.get().toStringUtf8();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "rsp.cookie.get().toStringUtf8()");
        Object localObject2 = Charsets.UTF_8;
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
          paramIColumnListCallback.a(0, "", (byte[])localObject1, paramArrayOfByte.is_end.get(), (List)localArrayList);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      QLog.e("ColumnModuleImpl", 1, "handleGetTopicListSuccessResult no topicInfo data!");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label275:
      break label275;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColumnModuleImpl", 2, "loadColumnListFromNetwork failed.");
    }
    if (paramIColumnListCallback != null) {
      paramIColumnListCallback.a(-1, "", null, true, null);
    }
    label308:
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ManageColumnModel createColumn: columnInfo : ");
      localStringBuilder.append(paramTopicInfo);
      QLog.e("ColumnModuleImpl", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ManageColumnModel editColumn: columnInfo : ");
      localStringBuilder.append(paramTopicInfo);
      QLog.e("ColumnModuleImpl", 2, localStringBuilder.toString());
    }
    a(paramTopicInfo, paramIColumnCallback, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.column.ColumnModeImpl
 * JD-Core Version:    0.7.0.1
 */