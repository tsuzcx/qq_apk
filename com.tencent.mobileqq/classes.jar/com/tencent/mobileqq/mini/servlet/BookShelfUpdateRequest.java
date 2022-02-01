package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf.StUpdateBookShelfReadTimeReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StUpdateBookShelfReadTimeRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class BookShelfUpdateRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.UpdateBookShelfReadTime";
  public static final String TAG = "BookShelfUpdateRequest";
  private MiniBookShelf.StUpdateBookShelfReadTimeReq req = new MiniBookShelf.StUpdateBookShelfReadTimeReq();
  
  public BookShelfUpdateRequest(String paramString1, String paramString2, String paramString3)
  {
    this.req.appid.set(paramString1);
    this.req.category.set(paramString2);
    this.req.contentId.set(paramString3);
  }
  
  public static MiniBookShelf.StUpdateBookShelfReadTimeRsp onResponse(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new MiniBookShelf.StUpdateBookShelfReadTimeRsp();
      ((MiniBookShelf.StUpdateBookShelfReadTimeRsp)localObject).mergeFrom(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse fail.");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("BookShelfUpdateRequest", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BookShelfUpdateRequest
 * JD-Core Version:    0.7.0.1
 */