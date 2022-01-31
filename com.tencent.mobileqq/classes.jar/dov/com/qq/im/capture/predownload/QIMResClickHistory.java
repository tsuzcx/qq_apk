package dov.com.qq.im.capture.predownload;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="resId, resType")
public class QIMResClickHistory
  extends Entity
{
  public String resId;
  public String resType;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.predownload.QIMResClickHistory
 * JD-Core Version:    0.7.0.1
 */