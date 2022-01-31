import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class tfx
{
  public int a;
  public long a;
  @Nullable
  public StoryVideoItem a;
  @Nullable
  public String a;
  public boolean a;
  public int b;
  public long b;
  @Nullable
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public tfx()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static tfx a(List<tfx> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tfx localtfx = (tfx)paramList.next();
      if (paramLong == localtfx.jdField_a_of_type_Long) {
        return localtfx;
      }
    }
    return null;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoIndex", this.jdField_a_of_type_Long);
      localJSONObject.put("didRead", this.jdField_a_of_type_Boolean);
      localJSONObject.put("vid", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("feedId", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("recommandId", this.jdField_b_of_type_Long);
      localJSONObject.put("showBottom", this.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(this.c)) {
        localJSONObject.put("bottomWording", this.c);
      }
      if (!TextUtils.isEmpty(this.d)) {
        localJSONObject.put("bottomLink", this.d);
      }
      localJSONObject.put("showText", this.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(this.e)) {
        localJSONObject.put("textWording", this.e);
      }
      if (!TextUtils.isEmpty(this.f)) {
        localJSONObject.put("textLink", this.f);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public void a(qqstory_service.MsgTabNodeVideoInfo paramMsgTabNodeVideoInfo, ArrayDeque<String> paramArrayDeque)
  {
    this.jdField_a_of_type_Long = paramMsgTabNodeVideoInfo.uint64_video_index.get();
    boolean bool;
    if (paramMsgTabNodeVideoInfo.uint32_did_read.get() != 0)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (paramMsgTabNodeVideoInfo.vid.has()) {
        this.jdField_a_of_type_JavaLangString = paramMsgTabNodeVideoInfo.vid.get().toStringUtf8();
      }
      if (!paramMsgTabNodeVideoInfo.feed_id.has()) {
        break label287;
      }
      this.jdField_b_of_type_JavaLangString = paramMsgTabNodeVideoInfo.feed_id.get().toStringUtf8();
      if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, (CharSequence)paramArrayDeque.peek())) {
        paramArrayDeque.push(this.jdField_b_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (paramMsgTabNodeVideoInfo.video_info.has())
      {
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = new StoryVideoItem();
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.convertFrom(paramMsgTabNodeVideoInfo.video_info);
      }
      if (paramMsgTabNodeVideoInfo.recommand_id.has()) {
        this.jdField_b_of_type_Long = paramMsgTabNodeVideoInfo.recommand_id.get();
      }
      if (paramMsgTabNodeVideoInfo.show_bottom.has()) {
        this.jdField_a_of_type_Int = paramMsgTabNodeVideoInfo.show_bottom.get();
      }
      if (paramMsgTabNodeVideoInfo.bottom_wording.has()) {
        this.c = paramMsgTabNodeVideoInfo.bottom_wording.get();
      }
      if (paramMsgTabNodeVideoInfo.bottom_link.has()) {
        this.d = paramMsgTabNodeVideoInfo.bottom_link.get();
      }
      if (paramMsgTabNodeVideoInfo.show_text.has()) {
        this.jdField_b_of_type_Int = paramMsgTabNodeVideoInfo.show_text.get();
      }
      if (paramMsgTabNodeVideoInfo.text_wording.has()) {
        this.e = paramMsgTabNodeVideoInfo.text_wording.get();
      }
      if (paramMsgTabNodeVideoInfo.text_link.has()) {
        this.f = paramMsgTabNodeVideoInfo.text_link.get();
      }
      return;
      bool = false;
      break;
      label287:
      paramArrayDeque = (String)paramArrayDeque.peek();
      if (paramArrayDeque != null) {
        this.jdField_b_of_type_JavaLangString = paramArrayDeque;
      }
    }
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_Long = paramJSONObject.getLong("videoIndex");
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("didRead");
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("vid", "");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("feedId", "");
      this.jdField_b_of_type_Long = paramJSONObject.optLong("recommandId");
      this.jdField_a_of_type_Int = paramJSONObject.optInt("showBottom");
      this.c = paramJSONObject.optString("bottomWording", "");
      this.d = paramJSONObject.optString("bottomLink", "");
      this.jdField_b_of_type_Int = paramJSONObject.optInt("showText");
      this.e = paramJSONObject.optString("textWording", "");
      this.f = paramJSONObject.optString("textLink", "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcw)tcz.a(5)).a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof tfx)) {
        return false;
      }
      paramObject = (tfx)paramObject;
    } while (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long);
    return false;
  }
  
  public String toString()
  {
    return "MsgTabNodeVideoInfo{videoIndex=" + this.jdField_a_of_type_Long + ", didRead=" + this.jdField_a_of_type_Boolean + ", vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", feedId='" + this.jdField_b_of_type_JavaLangString + '\'' + ", storyItem=" + this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem + ", recommandId=" + this.jdField_b_of_type_Long + ", showBottom=" + this.jdField_a_of_type_Int + ", bottomWording=" + this.c + ", bottomLink=" + this.d + ", showText=" + this.jdField_b_of_type_Int + ", textWording=" + this.e + ", textLink=" + this.f + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfx
 * JD-Core Version:    0.7.0.1
 */