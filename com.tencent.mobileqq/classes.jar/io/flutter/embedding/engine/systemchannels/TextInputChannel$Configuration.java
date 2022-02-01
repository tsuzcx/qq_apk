package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextInputChannel$Configuration
{
  @Nullable
  public final String actionLabel;
  public final boolean autocorrect;
  @Nullable
  public final TextInputChannel.Configuration.Autofill autofill;
  public final boolean enableSuggestions;
  @Nullable
  public final Configuration[] fields;
  @Nullable
  public final Integer inputAction;
  @NonNull
  public final TextInputChannel.InputType inputType;
  public final boolean obscureText;
  @NonNull
  public final TextInputChannel.TextCapitalization textCapitalization;
  
  public TextInputChannel$Configuration(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NonNull TextInputChannel.TextCapitalization paramTextCapitalization, @NonNull TextInputChannel.InputType paramInputType, @Nullable Integer paramInteger, @Nullable String paramString, @Nullable TextInputChannel.Configuration.Autofill paramAutofill, @Nullable Configuration[] paramArrayOfConfiguration)
  {
    this.obscureText = paramBoolean1;
    this.autocorrect = paramBoolean2;
    this.enableSuggestions = paramBoolean3;
    this.textCapitalization = paramTextCapitalization;
    this.inputType = paramInputType;
    this.inputAction = paramInteger;
    this.actionLabel = paramString;
    this.autofill = paramAutofill;
    this.fields = paramArrayOfConfiguration;
  }
  
  public static Configuration fromJson(@NonNull JSONObject paramJSONObject)
  {
    String str = paramJSONObject.getString("inputAction");
    if (str != null)
    {
      boolean bool1 = paramJSONObject.isNull("fields");
      Object localObject1 = null;
      Configuration[] arrayOfConfiguration;
      if (!bool1)
      {
        localObject2 = paramJSONObject.getJSONArray("fields");
        arrayOfConfiguration = new Configuration[((JSONArray)localObject2).length()];
        int i = 0;
        while (i < arrayOfConfiguration.length)
        {
          arrayOfConfiguration[i] = fromJson(((JSONArray)localObject2).getJSONObject(i));
          i += 1;
        }
      }
      else
      {
        arrayOfConfiguration = null;
      }
      Object localObject2 = inputActionFromTextInputAction(str);
      bool1 = paramJSONObject.optBoolean("obscureText");
      boolean bool2 = paramJSONObject.optBoolean("autocorrect", true);
      boolean bool3 = paramJSONObject.optBoolean("enableSuggestions");
      TextInputChannel.TextCapitalization localTextCapitalization = TextInputChannel.TextCapitalization.fromValue(paramJSONObject.getString("textCapitalization"));
      TextInputChannel.InputType localInputType = TextInputChannel.InputType.fromJson(paramJSONObject.getJSONObject("inputType"));
      if (paramJSONObject.isNull("actionLabel")) {
        str = null;
      } else {
        str = paramJSONObject.getString("actionLabel");
      }
      if (paramJSONObject.isNull("autofill")) {
        paramJSONObject = localObject1;
      } else {
        paramJSONObject = TextInputChannel.Configuration.Autofill.fromJson(paramJSONObject.getJSONObject("autofill"));
      }
      return new Configuration(bool1, bool2, bool3, localTextCapitalization, localInputType, (Integer)localObject2, str, paramJSONObject, arrayOfConfiguration);
    }
    paramJSONObject = new JSONException("Configuration JSON missing 'inputAction' property.");
    for (;;)
    {
      throw paramJSONObject;
    }
  }
  
  @NonNull
  private static Integer inputActionFromTextInputAction(@NonNull String paramString)
  {
    int i = paramString.hashCode();
    Integer localInteger = Integer.valueOf(0);
    switch (i)
    {
    default: 
      break;
    case 2110497650: 
      if (paramString.equals("TextInputAction.previous")) {
        i = 8;
      }
      break;
    case 1539450297: 
      if (paramString.equals("TextInputAction.newline")) {
        i = 0;
      }
      break;
    case 1241689507: 
      if (paramString.equals("TextInputAction.go")) {
        i = 4;
      }
      break;
    case 469250275: 
      if (paramString.equals("TextInputAction.search")) {
        i = 5;
      }
      break;
    case -736940669: 
      if (paramString.equals("TextInputAction.send")) {
        i = 6;
      }
      break;
    case -737080013: 
      if (paramString.equals("TextInputAction.none")) {
        i = 1;
      }
      break;
    case -737089298: 
      if (paramString.equals("TextInputAction.next")) {
        i = 7;
      }
      break;
    case -737377923: 
      if (paramString.equals("TextInputAction.done")) {
        i = 3;
      }
      break;
    case -810971940: 
      if (paramString.equals("TextInputAction.unspecified")) {
        i = 2;
      }
      break;
    }
    i = -1;
    switch (i)
    {
    default: 
      return localInteger;
    case 8: 
      return Integer.valueOf(7);
    case 7: 
      return Integer.valueOf(5);
    case 6: 
      return Integer.valueOf(4);
    case 5: 
      return Integer.valueOf(3);
    case 4: 
      return Integer.valueOf(2);
    case 3: 
      return Integer.valueOf(6);
    case 2: 
      return localInteger;
    }
    return Integer.valueOf(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration
 * JD-Core Version:    0.7.0.1
 */