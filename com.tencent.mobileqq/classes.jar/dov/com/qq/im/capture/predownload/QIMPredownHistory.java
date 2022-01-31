package dov.com.qq.im.capture.predownload;

import awge;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="resId,resType")
public class QIMPredownHistory
  extends awge
{
  public String resId;
  public String resType;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.predownload.QIMPredownHistory
 * JD-Core Version:    0.7.0.1
 */