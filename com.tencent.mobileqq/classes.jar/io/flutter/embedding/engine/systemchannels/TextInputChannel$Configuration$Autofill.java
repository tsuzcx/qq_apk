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
    int j = Build.VERSION.SDK_INT;
    int i = 26;
    if (j < 26) {
      return paramString;
    }
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2011773919: 
      if (paramString.equals("birthdayDay")) {
        i = 3;
      }
      break;
    case 2011152728: 
      if (paramString.equals("postalCode")) {
        i = 30;
      }
      break;
    case 1921869058: 
      if (paramString.equals("postalAddressExtended")) {
        i = 28;
      }
      break;
    case 1662667945: 
      if (paramString.equals("postalAddress")) {
        i = 27;
      }
      break;
    case 1469046696: 
      if (paramString.equals("givenName")) {
        i = 17;
      }
      break;
    case 1216985755: 
      if (!paramString.equals("password")) {
        break;
      }
      break;
    case 1069376125: 
      if (paramString.equals("birthday")) {
        i = 2;
      }
      break;
    case 991032982: 
      if (paramString.equals("newUsername")) {
        i = 24;
      }
      break;
    case 892233837: 
      if (paramString.equals("telephoneNumber")) {
        i = 31;
      }
      break;
    case 798554127: 
      if (paramString.equals("familyName")) {
        i = 14;
      }
      break;
    case 588174851: 
      if (paramString.equals("birthdayMonth")) {
        i = 4;
      }
      break;
    case 253202685: 
      if (paramString.equals("addressState")) {
        i = 1;
      }
      break;
    case 96619420: 
      if (paramString.equals("email")) {
        i = 13;
      }
      break;
    case 3373707: 
      if (paramString.equals("name")) {
        i = 20;
      }
      break;
    case -265713450: 
      if (paramString.equals("username")) {
        i = 35;
      }
      break;
    case -549230602: 
      if (paramString.equals("telephoneNumberCountryCode")) {
        i = 32;
      }
      break;
    case -613352043: 
      if (paramString.equals("creditCardExpirationYear")) {
        i = 10;
      }
      break;
    case -613980922: 
      if (paramString.equals("creditCardExpirationDate")) {
        i = 7;
      }
      break;
    case -747304516: 
      if (paramString.equals("nameSuffix")) {
        i = 22;
      }
      break;
    case -818219584: 
      if (paramString.equals("middleName")) {
        i = 19;
      }
      break;
    case -835992323: 
      if (paramString.equals("namePrefix")) {
        i = 21;
      }
      break;
    case -1151034798: 
      if (paramString.equals("creditCardNumber")) {
        i = 11;
      }
      break;
    case -1186060294: 
      if (paramString.equals("postalAddressExtendedPostalCode")) {
        i = 29;
      }
      break;
    case -1249512767: 
      if (paramString.equals("gender")) {
        i = 16;
      }
      break;
    case -1377792129: 
      if (paramString.equals("addressCity")) {
        i = 0;
      }
      break;
    case -1413737489: 
      if (paramString.equals("middleInitial")) {
        i = 18;
      }
      break;
    case -1476752575: 
      if (paramString.equals("countryName")) {
        i = 6;
      }
      break;
    case -1567118045: 
      if (paramString.equals("telephoneNumberDevice")) {
        i = 33;
      }
      break;
    case -1658955742: 
      if (paramString.equals("fullStreetAddress")) {
        i = 15;
      }
      break;
    case -1682373820: 
      if (paramString.equals("creditCardExpirationDay")) {
        i = 8;
      }
      break;
    case -1757573738: 
      if (paramString.equals("creditCardSecurityCode")) {
        i = 12;
      }
      break;
    case -1821235109: 
      if (paramString.equals("newPassword")) {
        i = 23;
      }
      break;
    case -1825589953: 
      if (paramString.equals("telephoneNumberNational")) {
        i = 34;
      }
      break;
    case -1844815832: 
      if (paramString.equals("creditCardExpirationMonth")) {
        i = 9;
      }
      break;
    case -1917283616: 
      if (paramString.equals("oneTimeCode")) {
        i = 25;
      }
      break;
    case -2058889126: 
      if (paramString.equals("birthdayYear")) {
        i = 5;
      }
      break;
    }
    i = -1;
    switch (i)
    {
    default: 
      return paramString;
    case 35: 
      return "username";
    case 34: 
      return "phoneNational";
    case 33: 
      return "phoneNumberDevice";
    case 32: 
      return "phoneCountryCode";
    case 31: 
      return "phoneNumber";
    case 30: 
      return "postalCode";
    case 29: 
      return "extendedPostalCode";
    case 28: 
      return "extendedAddress";
    case 27: 
      return "postalAddress";
    case 26: 
      return "password";
    case 25: 
      return "smsOTPCode";
    case 24: 
      return "newUsername";
    case 23: 
      return "newPassword";
    case 22: 
      return "personNameSuffix";
    case 21: 
      return "personNamePrefix";
    case 20: 
      return "personName";
    case 19: 
      return "personMiddleName";
    case 18: 
      return "personMiddleInitial";
    case 17: 
      return "personGivenName";
    case 16: 
      return "gender";
    case 15: 
      return "streetAddress";
    case 14: 
      return "personFamilyName";
    case 13: 
      return "emailAddress";
    case 12: 
      return "creditCardSecurityCode";
    case 11: 
      return "creditCardNumber";
    case 10: 
      return "creditCardExpirationYear";
    case 9: 
      return "creditCardExpirationMonth";
    case 8: 
      return "creditCardExpirationDay";
    case 7: 
      return "creditCardExpirationDate";
    case 6: 
      return "addressCountry";
    case 5: 
      return "birthDateYear";
    case 4: 
      return "birthDateMonth";
    case 3: 
      return "birthDateDay";
    case 2: 
      return "birthDateFull";
    case 1: 
      return "addressRegion";
    }
    return "addressLocality";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.Configuration.Autofill
 * JD-Core Version:    0.7.0.1
 */