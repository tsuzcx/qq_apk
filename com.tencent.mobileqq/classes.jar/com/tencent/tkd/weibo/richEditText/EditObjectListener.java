package com.tencent.tkd.weibo.richEditText;

import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;", "", "addRichEditObjectFailed", "", "editObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "extraInfo", "Lorg/json/JSONObject;", "onRichEditObjectChanged", "isAdd", "", "type", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "id", "", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public abstract interface EditObjectListener
{
  public abstract void a(@NotNull EditObject paramEditObject, @Nullable JSONObject paramJSONObject);
  
  public abstract void a(boolean paramBoolean, @NotNull EditObject.EditObjectType paramEditObjectType, @NotNull String paramString, @Nullable JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.EditObjectListener
 * JD-Core Version:    0.7.0.1
 */