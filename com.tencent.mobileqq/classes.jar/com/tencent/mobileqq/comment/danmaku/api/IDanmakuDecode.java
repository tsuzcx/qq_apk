package com.tencent.mobileqq.comment.danmaku.api;

import android.graphics.Paint;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.oidb.oidb_0xdea.Comment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IDanmakuDecode
  extends QRouteApi
{
  public abstract List<DanmuItemBean> decodeCommentList(List<oidb_0xdea.Comment> paramList, long paramLong, Paint paramPaint, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.api.IDanmakuDecode
 * JD-Core Version:    0.7.0.1
 */