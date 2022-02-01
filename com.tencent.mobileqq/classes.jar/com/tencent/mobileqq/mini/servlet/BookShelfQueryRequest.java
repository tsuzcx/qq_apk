package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf.StQueryBookShelfReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StQueryBookShelfRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BookShelfQueryRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.QueryBookShelf";
  public static final String TAG = "BookShelfQueryRequest";
  private MiniBookShelf.StQueryBookShelfReq req = new MiniBookShelf.StQueryBookShelfReq();
  
  public BookShelfQueryRequest(String paramString, ArrayList<String> paramArrayList)
  {
    this.req.appid.set(paramString);
    if (paramArrayList != null) {
      this.req.contentIds.addAll(paramArrayList);
    }
  }
  
  public static MiniBookShelf.StQueryBookShelfRsp onResponse(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new MiniBookShelf.StQueryBookShelfRsp();
      ((MiniBookShelf.StQueryBookShelfRsp)localObject).mergeFrom(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse fail.");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("BookShelfQueryRequest", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BookShelfQueryRequest
 * JD-Core Version:    0.7.0.1
 */