package org.apache.http.auth;

import java.security.Principal;

@Deprecated
public abstract interface Credentials
{
  public abstract String getPassword();
  
  public abstract Principal getUserPrincipal();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.auth.Credentials
 * JD-Core Version:    0.7.0.1
 */