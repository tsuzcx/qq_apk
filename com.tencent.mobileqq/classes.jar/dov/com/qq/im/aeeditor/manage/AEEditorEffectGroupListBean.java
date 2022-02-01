package dov.com.qq.im.aeeditor.manage;

import android.text.TextUtils;
import bnrh;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AEEditorEffectGroupListBean
  implements Serializable
{
  public static final String TAG = "AEEditorEffectGroupListBean";
  public List<AEEditorEffectGroupListBean.AEEditorEffectGroupItem> effectGroups = new ArrayList();
  public String version = "";
  
  private static void a(List<AEEditorEffectGroupListBean.AEEditorEffectGroupItem> paramList, JSONArray paramJSONArray)
  {
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
      i = 0;
    }
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      AEEditorEffectGroupListBean.AEEditorEffectGroupItem localAEEditorEffectGroupItem = new AEEditorEffectGroupListBean.AEEditorEffectGroupItem();
      localAEEditorEffectGroupItem.effectGroupID = ((JSONObject)localObject).optString("effectGroupID");
      localAEEditorEffectGroupItem.effectGroupName = ((JSONObject)localObject).optString("effectGroupName");
      localObject = ((JSONObject)localObject).optJSONArray("effects");
      b(localAEEditorEffectGroupItem.effects, (JSONArray)localObject);
      paramList.add(localAEEditorEffectGroupItem);
      i += 1;
      continue;
      bnrh.d("AEEditorEffectGroupListBean", "group list empty.");
    }
  }
  
  private static void b(List<AEEditorEffectGroupListBean.AEEditorEffectItem> paramList, JSONArray paramJSONArray)
  {
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
      i = 0;
    }
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      AEEditorEffectGroupListBean.AEEditorEffectItem localAEEditorEffectItem = new AEEditorEffectGroupListBean.AEEditorEffectItem();
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$002(localAEEditorEffectItem, localJSONObject.optString("effectID"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$102(localAEEditorEffectItem, localJSONObject.optString("effectName"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$202(localAEEditorEffectItem, localJSONObject.optString("thumbURL"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$302(localAEEditorEffectItem, localJSONObject.optInt("hideApplyAll"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$402(localAEEditorEffectItem, localJSONObject.optInt("hideAlphaBar"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$502(localAEEditorEffectItem, localJSONObject.optInt("disableForImage"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$602(localAEEditorEffectItem, localJSONObject.optInt("disableForVideo"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$702(localAEEditorEffectItem, localJSONObject.optInt("imageShowLevel"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$802(localAEEditorEffectItem, localJSONObject.optInt("videoShowLevel"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$902(localAEEditorEffectItem, localJSONObject.optString("effectType"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1002(localAEEditorEffectItem, localJSONObject.optInt("netStylizeType"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1102(localAEEditorEffectItem, localJSONObject.optInt("preDownload"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1202(localAEEditorEffectItem, localJSONObject.optString("resourceMD5"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1302(localAEEditorEffectItem, localJSONObject.optString("resourceURL"));
      AEEditorEffectGroupListBean.AEEditorEffectItem.access$1402(localAEEditorEffectItem, localJSONObject.optInt("uploadMaxSize"));
      paramList.add(localAEEditorEffectItem);
      i += 1;
      continue;
      bnrh.d("AEEditorEffectGroupListBean", "effect list is empty.");
    }
  }
  
  public static AEEditorEffectGroupListBean parse(String paramString)
  {
    AEEditorEffectGroupListBean localAEEditorEffectGroupListBean = new AEEditorEffectGroupListBean();
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      localAEEditorEffectGroupListBean.version = paramString.optString("version");
      paramString = paramString.optJSONArray("effectGroups");
      a(localAEEditorEffectGroupListBean.effectGroups, paramString);
      return localAEEditorEffectGroupListBean;
    }
    catch (Exception paramString)
    {
      bnrh.d("AEEditorEffectGroupListBean", paramString.toString());
    }
    return localAEEditorEffectGroupListBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean
 * JD-Core Version:    0.7.0.1
 */