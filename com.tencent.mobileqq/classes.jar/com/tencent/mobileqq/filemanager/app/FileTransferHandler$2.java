package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;

class FileTransferHandler$2
  implements ProtoReqManagerImpl.IProtoRespBack
{
  FileTransferHandler$2(FileTransferHandler paramFileTransferHandler) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100".equals(paramProtoReq.ssoCmd)) {
      FileTransferHandler.a(this.a, paramProtoReq, paramProtoResp);
    }
    do
    {
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200".equals(paramProtoReq.ssoCmd))
      {
        FileTransferHandler.b(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD-500".equals(paramProtoReq.ssoCmd))
      {
        FileTransferHandler.c(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(paramProtoReq.ssoCmd))
      {
        FileTransferHandler.d(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramProtoReq.ssoCmd))
      {
        this.a.a(paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DOWNLOAD_SUCC-1000".equals(paramProtoReq.ssoCmd))
      {
        this.a.b(paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(paramProtoReq.ssoCmd))
      {
        this.a.d(paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(paramProtoReq.ssoCmd))
      {
        this.a.e(paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD_ABS-1100".equals(paramProtoReq.ssoCmd))
      {
        this.a.c(paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_DELETE_FILE-900".equals(paramProtoReq.ssoCmd))
      {
        FileTransferHandler.e(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(paramProtoReq.ssoCmd))
      {
        FileTransferHandler.f(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600".equals(paramProtoReq.ssoCmd))
      {
        this.a.g(paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(paramProtoReq.ssoCmd))
      {
        this.a.f(paramProtoReq, paramProtoResp);
        return;
      }
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800".equals(paramProtoReq.ssoCmd))
      {
        FileTransferHandler.g(this.a, paramProtoReq, paramProtoResp);
        return;
      }
      if ("SafeCenterSvr.CMD_FACE2FACE_FLAG_REQ".equals(paramProtoReq.ssoCmd))
      {
        FileTransferHandler.h(this.a, paramProtoReq, paramProtoResp);
        return;
      }
    } while (!"OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECALL-400".equals(paramProtoReq.ssoCmd));
    FileTransferHandler.i(this.a, paramProtoReq, paramProtoResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.2
 * JD-Core Version:    0.7.0.1
 */