package com.tencent.viola.commons;

import org.json.JSONArray;

public class AssocioationEvents
{
  public static final String ASSOCIOATION_KEY_APPLY_LAYOUT = "applyLayout";
  public static String ASSOCIOATION_KEY_CALLBACK_CONDITION;
  public static String ASSOCIOATION_KEY_EVENT;
  public static String ASSOCIOATION_KEY_PROPS;
  public static String ASSOCIOATION_KEY_REF = "ref";
  public static final String ASSOCIOATION_KEY_SYNC = "sync";
  public static String ASSOCIOATION_PROPS_KEY_ATTR = "attr";
  public static String ASSOCIOATION_PROPS_KEY_STYLE;
  public static String ASSOCIOATION_PROPS_KEY_TARGET;
  public boolean applyLayout;
  public String mCallbackCondition;
  public String mCallbackId;
  public String mEvent;
  public JSONArray mProps;
  public String mRef;
  public boolean sync;
  
  static
  {
    ASSOCIOATION_KEY_EVENT = "event";
    ASSOCIOATION_KEY_PROPS = "props";
    ASSOCIOATION_KEY_CALLBACK_CONDITION = "callbackCondition";
    ASSOCIOATION_PROPS_KEY_TARGET = "target";
    ASSOCIOATION_PROPS_KEY_STYLE = "style";
  }
  
  public AssocioationEvents(String paramString1, String paramString2, JSONArray paramJSONArray, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mRef = paramString1;
    this.mEvent = paramString2;
    this.mProps = paramJSONArray;
    this.mCallbackCondition = paramString3;
    this.mCallbackId = paramString4;
    this.sync = paramBoolean1;
    this.applyLayout = paramBoolean2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AssocioationEvents:[");
    localStringBuilder.append("\n |-").append("mRef :").append(this.mRef);
    localStringBuilder.append("\n |-").append("mEvent :").append(this.mEvent);
    localStringBuilder.append("\n |-").append("mProps :").append(this.mProps.toString());
    localStringBuilder.append("\n |-").append("mCallbackCondition :").append(this.mCallbackCondition);
    localStringBuilder.append("\n |-").append("mCallbackId :").append(this.mCallbackId);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.commons.AssocioationEvents
 * JD-Core Version:    0.7.0.1
 */