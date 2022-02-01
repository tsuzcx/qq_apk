package com.tencent.mobileqq.mini.servlet;

import NS_MINI_BOOK_SHELF.MiniBookShelf.StInsertBookShelfReq;
import NS_MINI_BOOK_SHELF.MiniBookShelf.StInsertBookShelfRsp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BookShelfInsertRequest
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_book_shelf.InsertBookShelf";
  public static final String TAG = "BookShelfInsertRequest";
  private MiniBookShelf.StInsertBookShelfReq req = new MiniBookShelf.StInsertBookShelfReq();
  
  public BookShelfInsertRequest(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    this.req.appid.set(paramString1);
    this.req.category.set(paramString2);
    if (paramArrayList != null) {
      this.req.contentIds.addAll(paramArrayList);
    }
  }
  
  public static MiniBookShelf.StInsertBookShelfRsp onResponse(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = new MiniBookShelf.StInsertBookShelfRsp();
      ((MiniBookShelf.StInsertBookShelfRsp)localObject).mergeFrom(paramArrayOfByte);
      return localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse fail.");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("BookShelfInsertRequest", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BookShelfInsertRequest
 * JD-Core Version:    0.7.0.1
 */