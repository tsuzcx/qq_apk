package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class InfomationFacePackage
  extends FacePackage
{
  public static boolean b;
  public List a = new ArrayList();
  public String f;
  
  public InfomationFacePackage(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FacePackage", 2, "readyToGetItemFromJsonArray" + i);
      }
      InfomationFacePackage.Item localItem = new InfomationFacePackage.Item(paramJSONArray.getJSONObject(i));
      localArrayList.add(localItem);
      if (QLog.isColorLevel()) {
        QLog.d("FacePackage", 2, "getItemFromJsonArray" + localItem);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public String a()
  {
    return "InformationFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((InfomationFacePackage.Item)this.a.get(paramInt)).b;
    }
    return null;
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((InfomationFacePackage.Item)this.a.get(paramInt)).c;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage
 * JD-Core Version:    0.7.0.1
 */