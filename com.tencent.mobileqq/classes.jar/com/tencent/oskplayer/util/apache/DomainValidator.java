package com.tencent.oskplayer.util.apache;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class DomainValidator
  implements Serializable
{
  private static final String[] COUNTRY_CODE_TLDS;
  private static final List COUNTRY_CODE_TLD_LIST = Arrays.asList(COUNTRY_CODE_TLDS);
  private static final String DOMAIN_LABEL_REGEX = "\\p{Alnum}(?>[\\p{Alnum}-]*\\p{Alnum})*";
  private static final String DOMAIN_NAME_REGEX = "^(?:\\p{Alnum}(?>[\\p{Alnum}-]*\\p{Alnum})*\\.)+(\\p{Alpha}{2,})$";
  private static final DomainValidator DOMAIN_VALIDATOR = new DomainValidator(false);
  private static final DomainValidator DOMAIN_VALIDATOR_WITH_LOCAL = new DomainValidator(true);
  private static final String[] GENERIC_TLDS;
  private static final List GENERIC_TLD_LIST;
  private static final String[] INFRASTRUCTURE_TLDS = { "arpa", "root" };
  private static final List INFRASTRUCTURE_TLD_LIST;
  private static final String[] LOCAL_TLDS;
  private static final List LOCAL_TLD_LIST = Arrays.asList(LOCAL_TLDS);
  private static final String TOP_LABEL_REGEX = "\\p{Alpha}{2,}";
  private static final long serialVersionUID = -4407125112880174009L;
  private final boolean allowLocal;
  private final RegexValidator domainRegex = new RegexValidator("^(?:\\p{Alnum}(?>[\\p{Alnum}-]*\\p{Alnum})*\\.)+(\\p{Alpha}{2,})$");
  private final RegexValidator hostnameRegex = new RegexValidator("\\p{Alnum}(?>[\\p{Alnum}-]*\\p{Alnum})*");
  
  static
  {
    GENERIC_TLDS = new String[] { "aero", "asia", "biz", "cat", "com", "coop", "info", "jobs", "mobi", "museum", "name", "net", "org", "pro", "tel", "travel", "gov", "edu", "mil", "int" };
    COUNTRY_CODE_TLDS = new String[] { "ac", "ad", "ae", "af", "ag", "ai", "al", "am", "an", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bm", "bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "er", "es", "et", "eu", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "st", "su", "sv", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tp", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "uk", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "yu", "za", "zm", "zw" };
    LOCAL_TLDS = new String[] { "localhost", "localdomain" };
    INFRASTRUCTURE_TLD_LIST = Arrays.asList(INFRASTRUCTURE_TLDS);
    GENERIC_TLD_LIST = Arrays.asList(GENERIC_TLDS);
  }
  
  private DomainValidator(boolean paramBoolean)
  {
    this.allowLocal = paramBoolean;
  }
  
  private String chompLeadingDot(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith(".")) {
      str = paramString.substring(1);
    }
    return str;
  }
  
  public static DomainValidator getInstance()
  {
    return DOMAIN_VALIDATOR;
  }
  
  public static DomainValidator getInstance(boolean paramBoolean)
  {
    if (paramBoolean) {
      return DOMAIN_VALIDATOR_WITH_LOCAL;
    }
    return DOMAIN_VALIDATOR;
  }
  
  public boolean isValid(String paramString)
  {
    String[] arrayOfString = this.domainRegex.match(paramString);
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      return isValidTld(arrayOfString[0]);
    }
    return (this.allowLocal) && (this.hostnameRegex.isValid(paramString));
  }
  
  public boolean isValidCountryCodeTld(String paramString)
  {
    return COUNTRY_CODE_TLD_LIST.contains(chompLeadingDot(paramString.toLowerCase()));
  }
  
  public boolean isValidGenericTld(String paramString)
  {
    return GENERIC_TLD_LIST.contains(chompLeadingDot(paramString.toLowerCase()));
  }
  
  public boolean isValidInfrastructureTld(String paramString)
  {
    return INFRASTRUCTURE_TLD_LIST.contains(chompLeadingDot(paramString.toLowerCase()));
  }
  
  public boolean isValidLocalTld(String paramString)
  {
    return LOCAL_TLD_LIST.contains(chompLeadingDot(paramString.toLowerCase()));
  }
  
  public boolean isValidTld(String paramString)
  {
    boolean bool1 = this.allowLocal;
    boolean bool2 = true;
    if ((bool1) && (isValidLocalTld(paramString))) {
      return true;
    }
    bool1 = bool2;
    if (!isValidInfrastructureTld(paramString))
    {
      bool1 = bool2;
      if (!isValidGenericTld(paramString))
      {
        if (isValidCountryCodeTld(paramString)) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.apache.DomainValidator
 * JD-Core Version:    0.7.0.1
 */