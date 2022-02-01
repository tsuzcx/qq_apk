package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQLiveAnchorDataCheckPermission
  extends QQLiveAnchorDataBase
{
  public List<String> unGrantPermissions = new ArrayList();
  
  public QQLiveAnchorDataCheckPermission() {}
  
  public QQLiveAnchorDataCheckPermission(QQLiveAnchorDataCheckPermission paramQQLiveAnchorDataCheckPermission)
  {
    super(paramQQLiveAnchorDataCheckPermission);
    if (paramQQLiveAnchorDataCheckPermission == null) {
      return;
    }
    if (paramQQLiveAnchorDataCheckPermission.unGrantPermissions != null)
    {
      paramQQLiveAnchorDataCheckPermission = this.unGrantPermissions.iterator();
      while (paramQQLiveAnchorDataCheckPermission.hasNext())
      {
        String str = (String)paramQQLiveAnchorDataCheckPermission.next();
        this.unGrantPermissions.add(str);
      }
    }
  }
  
  public QQLiveAnchorDataCheckPermission(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super(paramBoolean, paramQQLiveErrorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataCheckPermission
 * JD-Core Version:    0.7.0.1
 */