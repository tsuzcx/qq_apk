package io.flutter.embedding.engine.systemchannels;

import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class TextInputChannel$Configuration$Autofill
{
  public final TextInputChannel.TextEditState editState;
  public final String[] hints;
  public final String uniqueIdentifier;
  
  public TextInputChannel$Configuration$Autofill(@NonNull String paramString, @NonNull String[] paramArrayOfString, @NonNull TextInputChannel.TextEditState paramTextEditState)
  {
    this.uniqueIdentifier = paramString;
    this.hints = paramArrayOfString;
    this.editState = paramTextEditState;
  }
  
  public static Autofill fromJson(@NonNull JSONObject paramJSONObject)
  {
    String str = paramJSONObject.getString("uniqueIdentifier");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("hints");
    paramJSONObject = paramJSONObject.getJSONObject("editingValue");
    String[] arrayOfString = new String[localJSONArray.length()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = translateAutofillHint(localJSONArray.getString(i));
      i += 1;
    }
    return new Autofill(str, arrayOfString, TextInputChannel.TextEditState.fromJson(paramJSONObject));
  }
  
  @NonNull
  private static String translateAutofillHint(@NonNull String paramString)
  {
    int i = 26;
    if (Build.VERSION.SDK_INT < 26) {
      return paramString;
    }
    switch (paramString.hashCode())
    {
    default: 
      label316:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return paramString;
      case 0: 
        return "addressLocality";
        if (!paramString.equals("birthdayDay")) {
          break label316;
        }
        i = 3;
        continue;
        if (!paramString.equals("postalCode")) {
          break label316;
        }
        i = 30;
        continue;
        if (!paramString.equals("postalAddressExtended")) {
          break label316;
        }
        i = 28;
        continue;
        if (!paramString.equals("postalAddress")) {
          break label316;
        }
        i = 27;
        continue;
        if (!paramString.equals("givenName")) {
          break label316;
        }
        i = 17;
        continue;
        if (!paramString.equals("password")) {
          break label316;
        }
        continue;
        if (!paramString.equals("birthday")) {
          break label316;
        }
        i = 2;
        continue;
        if (!paramString.equals("newUsername")) {
          break label316;
        }
        i = 24;
        continue;
        if (!paramString.equals("telephoneNumber")) {
          break label316;
        }
        i = 31;
        continue;
        if (!paramString.equals("familyName")) {
          break label316;
        }
        i = 14;
        continue;
        if (!paramString.equals("birthdayMonth")) {
          break label316;
        }
        i = 4;
        continue;
        if (!paramString.equals("addressState")) {
          break label316;
        }
        i = 1;
        continue;
        if (!paramString.equals("email")) {
          break label316;
        }
        i = 13;
        continue;
        if (!paramString.equals("name")) {
          break label316;
        }
        i = 20;
        continue;
        if (!paramString.equals("username")) {
          break label316;
        }
        i = 35;
        continue;
        if (!paramString.equals("telephoneNumberCountryCode")) {
          break label316;
        }
        i = 32;
        continue;
        if (!paramString.equals("creditCardExpirationYear")) {
          break label316;
        }
        i = 10;
        continue;
        if (!paramString.equals("creditCardExpirationDate")) {
          break label316;
        }
        i = 7;
        continue;
        if (!paramString.equals("nameSuffix")) {
          break label316;
        }
        i = 22;
        continue;
        if (!paramString.equals("middleName")) {
          break label316;
        }
        i = 19;
        continue;
        if (!paramString.equals("namePrefix")) {
          break label316;
        }
        i = 21;
        continue;
        if (!paramString.equals("creditCardNumber")) {
          break label316;
        }
        i = 11;
        continue;
        if (!paramString.equals("postalAddressExtendedPostalCode")) {
          break label316;
        }
        i = 29;
        continue;
        if (!paramString.equals("gender")) {
          break label316;
        }
        i = 16;
        continue;
        if (!paramString.equals("addressCity")) {
          break label316;
        }
        i = 0;
        continue;
        if (!paramString.equals("middleInitial")) {
          break label316;
        }
        i = 18;
        continue;
        if (!paramString.equals("countryName")) {
          break label316;
        }
        i = 6;
        continue;
        if (!paramString.equals("telephoneNumberDevice")) {
          break label316;
        }
        i = 33;
        continue;
        if (!paramString.equals("fullStreetAddress")) {
          break label316;
        }
        i = 15;
        continue;
        if (!paramString.equals("creditCardExpirationDay")) {
          break label316;
        }
        i = 8;
        continue;
        if (!paramString.equals("creditCardSecurityCode")) {
          break label316;
        }
        i = 12;
        continue;
        if (!paramString.equals("newPassword")) {
          break label316;
        }
        i = 23;
        continue;
        if (!paramString.equals("telephoneNumberNational")) {
          break label316;
        }
        i = 34;
        continue;
        if (!paramString.equals("creditCardExpirationMonth")) {
          break label316;
        }
        i = 9;
        continue;
        if (!paramString.equals("oneTimeCode")) {
          break label316;
        }
        i = 25;
        continue;
        if (!paramString.equals("birthdayYear")) {
          break label316;
        }
        i = 5;
      }
    }
    return "username";
    return "phoneNational";
    return "phoneNumberDevice";
    return "phoneCountryCode";
    return "phoneNumber";
    return "postalCode";
    return "extendedPostalCode";
    return "extendedAddress";
    return "postalAddress";
    return "password";
    return "smsOTPCode";
    return "newUsername";
    return "newPassword";
    return "personNameSuffix";
    return "personNamePrefix";
    return "personName";
    return "personMiddleName";
    return "personMiddleInitial";
    return "personGivenName";
    return "gender";
    return "streetAddress";
    return "personFamilyName";
    return "emailAddress";
    return "creditCardSecurityCode";
    return "creditCardNumber";
    return "creditCardExpirationYear";
    return "creditCardExpirationMonth";
    return "creditCardExpirationDay";
    return "creditCardExpirationDate";
    return "addressCountry";
    return "birthDateYear";
    return "birthDateMonth";
    return "birthDateDay";
    return "birthDateFull";
    return "addressRegion";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill
 * JD-Core Version:    0.7.0.1
 */