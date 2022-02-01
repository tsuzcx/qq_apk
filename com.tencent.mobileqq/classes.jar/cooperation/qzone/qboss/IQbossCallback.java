package cooperation.qzone.qboss;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public abstract interface IQbossCallback
{
  public abstract void getQbossFail(int paramInt, String paramString1, String paramString2, ArrayList<Integer> paramArrayList);
  
  public abstract void getQbossSuccess(Bundle paramBundle, String paramString, QQAppInterface paramQQAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.qboss.IQbossCallback
 * JD-Core Version:    0.7.0.1
 */