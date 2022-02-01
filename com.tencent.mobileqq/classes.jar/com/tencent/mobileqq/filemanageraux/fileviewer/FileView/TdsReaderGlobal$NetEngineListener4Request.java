package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

final class TdsReaderGlobal$NetEngineListener4Request
  implements INetEngineListener
{
  private final String a;
  private final IHostInterface.IHttpListener b;
  
  private TdsReaderGlobal$NetEngineListener4Request(String paramString, IHostInterface.IHttpListener paramIHttpListener)
  {
    this.a = paramString;
    this.b = paramIHttpListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    String str;
    if ((paramNetResp.mHttpCode != 200) && (paramNetResp.mHttpCode != 206)) {
      str = null;
    } else {
      str = new String(paramNetResp.mRespData);
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((IHostInterface.IHttpListener)localObject).onResponse(paramNetResp.mHttpCode, str);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResp url:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", status=");
    ((StringBuilder)localObject).append(paramNetResp.mHttpCode);
    ((StringBuilder)localObject).append(", rsp=");
    ((StringBuilder)localObject).append(str);
    Log.i("TdsReaderView_", ((StringBuilder)localObject).toString());
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.NetEngineListener4Request
 * JD-Core Version:    0.7.0.1
 */