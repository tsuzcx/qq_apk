package kotlin.reflect.jvm.internal.impl.incremental.components;

import org.jetbrains.annotations.Nullable;

public enum NoLookupLocation
  implements LookupLocation
{
  static
  {
    NoLookupLocation localNoLookupLocation1 = new NoLookupLocation("FROM_IDE", 0);
    FROM_IDE = localNoLookupLocation1;
    NoLookupLocation localNoLookupLocation2 = new NoLookupLocation("FROM_BACKEND", 1);
    FROM_BACKEND = localNoLookupLocation2;
    NoLookupLocation localNoLookupLocation3 = new NoLookupLocation("FROM_TEST", 2);
    FROM_TEST = localNoLookupLocation3;
    NoLookupLocation localNoLookupLocation4 = new NoLookupLocation("FROM_BUILTINS", 3);
    FROM_BUILTINS = localNoLookupLocation4;
    NoLookupLocation localNoLookupLocation5 = new NoLookupLocation("WHEN_CHECK_DECLARATION_CONFLICTS", 4);
    WHEN_CHECK_DECLARATION_CONFLICTS = localNoLookupLocation5;
    NoLookupLocation localNoLookupLocation6 = new NoLookupLocation("WHEN_CHECK_OVERRIDES", 5);
    WHEN_CHECK_OVERRIDES = localNoLookupLocation6;
    NoLookupLocation localNoLookupLocation7 = new NoLookupLocation("FOR_SCRIPT", 6);
    FOR_SCRIPT = localNoLookupLocation7;
    NoLookupLocation localNoLookupLocation8 = new NoLookupLocation("FROM_REFLECTION", 7);
    FROM_REFLECTION = localNoLookupLocation8;
    NoLookupLocation localNoLookupLocation9 = new NoLookupLocation("WHEN_RESOLVE_DECLARATION", 8);
    WHEN_RESOLVE_DECLARATION = localNoLookupLocation9;
    NoLookupLocation localNoLookupLocation10 = new NoLookupLocation("WHEN_GET_DECLARATION_SCOPE", 9);
    WHEN_GET_DECLARATION_SCOPE = localNoLookupLocation10;
    NoLookupLocation localNoLookupLocation11 = new NoLookupLocation("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);
    WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS = localNoLookupLocation11;
    NoLookupLocation localNoLookupLocation12 = new NoLookupLocation("FOR_ALREADY_TRACKED", 11);
    FOR_ALREADY_TRACKED = localNoLookupLocation12;
    NoLookupLocation localNoLookupLocation13 = new NoLookupLocation("WHEN_GET_ALL_DESCRIPTORS", 12);
    WHEN_GET_ALL_DESCRIPTORS = localNoLookupLocation13;
    NoLookupLocation localNoLookupLocation14 = new NoLookupLocation("WHEN_TYPING", 13);
    WHEN_TYPING = localNoLookupLocation14;
    NoLookupLocation localNoLookupLocation15 = new NoLookupLocation("WHEN_GET_SUPER_MEMBERS", 14);
    WHEN_GET_SUPER_MEMBERS = localNoLookupLocation15;
    NoLookupLocation localNoLookupLocation16 = new NoLookupLocation("FOR_NON_TRACKED_SCOPE", 15);
    FOR_NON_TRACKED_SCOPE = localNoLookupLocation16;
    NoLookupLocation localNoLookupLocation17 = new NoLookupLocation("FROM_SYNTHETIC_SCOPE", 16);
    FROM_SYNTHETIC_SCOPE = localNoLookupLocation17;
    NoLookupLocation localNoLookupLocation18 = new NoLookupLocation("FROM_DESERIALIZATION", 17);
    FROM_DESERIALIZATION = localNoLookupLocation18;
    NoLookupLocation localNoLookupLocation19 = new NoLookupLocation("FROM_JAVA_LOADER", 18);
    FROM_JAVA_LOADER = localNoLookupLocation19;
    NoLookupLocation localNoLookupLocation20 = new NoLookupLocation("WHEN_GET_LOCAL_VARIABLE", 19);
    WHEN_GET_LOCAL_VARIABLE = localNoLookupLocation20;
    NoLookupLocation localNoLookupLocation21 = new NoLookupLocation("WHEN_FIND_BY_FQNAME", 20);
    WHEN_FIND_BY_FQNAME = localNoLookupLocation21;
    NoLookupLocation localNoLookupLocation22 = new NoLookupLocation("WHEN_GET_COMPANION_OBJECT", 21);
    WHEN_GET_COMPANION_OBJECT = localNoLookupLocation22;
    NoLookupLocation localNoLookupLocation23 = new NoLookupLocation("FOR_DEFAULT_IMPORTS", 22);
    FOR_DEFAULT_IMPORTS = localNoLookupLocation23;
    $VALUES = new NoLookupLocation[] { localNoLookupLocation1, localNoLookupLocation2, localNoLookupLocation3, localNoLookupLocation4, localNoLookupLocation5, localNoLookupLocation6, localNoLookupLocation7, localNoLookupLocation8, localNoLookupLocation9, localNoLookupLocation10, localNoLookupLocation11, localNoLookupLocation12, localNoLookupLocation13, localNoLookupLocation14, localNoLookupLocation15, localNoLookupLocation16, localNoLookupLocation17, localNoLookupLocation18, localNoLookupLocation19, localNoLookupLocation20, localNoLookupLocation21, localNoLookupLocation22, localNoLookupLocation23 };
  }
  
  private NoLookupLocation() {}
  
  @Nullable
  public LocationInfo getLocation()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation
 * JD-Core Version:    0.7.0.1
 */